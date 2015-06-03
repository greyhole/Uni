#include "kernel.h"
#include "kernel_id.h"
#include "ecrobot_interface.h"
#include "bluetooth.h"
#include "nxt_config.h"
#include <string.h>

static U8 recvBuf[50];

void displ_line_int(int val, int line)
{
    display_goto_xy(0,line);
    display_int(val, 3);
    display_update();
}

void displ_line_str(char * message, int line)
{
    display_goto_xy(0,line);
    display_string(message);
    display_update();
}

void bt_displ_stat(int line)
{
    SINT bt_status = ecrobot_get_bt_status();

    char *bt_stat_message = "undefined";

    switch(bt_status)
    {
      case BT_NO_INIT :
        bt_stat_message = "not initialized";
        break;
      case BT_INITIALIZED :
        bt_stat_message = "initialized";
        break;
      case BT_CONNECTED :
        bt_stat_message = "connected";
        break;
        case BT_STREAM :
        bt_stat_message = "ready for send";
        break;
    }
    displ_line_str(bt_stat_message, line);
}

void bt_send_loop(void *send_buf, int message_size)
{
    int bytes_sent = 0;
    
    while(bytes_sent < message_size)
    {   
        bytes_sent += ecrobot_send_bt(send_buf, bytes_sent, message_size - bytes_sent);
    }   
}

void bt_receive_loop(void *recv_buf, int message_size)
{
    int bytes_received = 0;
    
    while(bytes_received < message_size)
    {
        bytes_received += ecrobot_read_bt(recv_buf, bytes_received, message_size - bytes_received);
    }
}

void bt_send_message(const void * status, int size)
{
    if (ecrobot_get_bt_status() == BT_STREAM && size < 50)
    {
        U8 send_buf[50];
        send_buf[0] = size;
        
        memcpy((void*)(send_buf + 1),status, size);
        
        bt_send_loop(send_buf, size + 1);
     }   
}

void bt_receive_message()
{
    U32 bytes_read = ecrobot_read_bt((void*) recvBuf, 0, 1);
    
    if (bytes_read == 1)
    {
        U8 message_size = recvBuf[0];
           
        displ_line_int(message_size,3);   
                
        if (message_size <= sizeof(recvBuf))
        {
            bt_receive_loop((void*) recvBuf, message_size);
            SetEvent(DecodeBtPackage, PackageReceivedEvent);
        }
        else
        {
            // message too long
            // displ_line_str("message size out of range", int line);
        }
    }
    
}

TASK(UpdateStatus)
{
    char status[] = "greetings from nxt4!!!";
    
    bt_send_message((void *) status, sizeof(status));
    
    TerminateTask();
}

TASK(FetchBtPackage)
{   
    ecrobot_init_bt_slave("1234");

    bt_displ_stat(1);
       
    bt_receive_message();
         
    TerminateTask();
}

TASK(DecodeBtPackage)
{
    while(1)
    {
        WaitEvent(PackageReceivedEvent);
        ClearEvent(PackageReceivedEvent);
        
        U8 command = recvBuf[0];
        
        /*
        switch (command)
        {
            case 0 :
                // command 0
                break;
            case 1 :
                //
                break;
            case 2 :
                //
            
        }
        */    
        displ_line_int(command, 3);
        
    }    
    
    TerminateTask();    
}
