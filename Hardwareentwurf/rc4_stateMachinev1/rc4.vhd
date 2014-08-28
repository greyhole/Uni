----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    19:30:57 08/26/2014 
-- Design Name: 
-- Module Name:    rc4 - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity rc4 is
    Port ( key : in  STD_LOGIC_VECTOR (7 downto 0);
           plain : in  STD_LOGIC_VECTOR (7 downto 0);
           reset : in  STD_LOGIC;
           clk : in  STD_LOGIC;
           cypher : out  STD_LOGIC_VECTOR (7 downto 0));
end rc4;

architecture Behavioral of rc4 is
signal di0 : STD_LOGIC_VECTOR (7 downto 0);
signal do0 : STD_LOGIC_VECTOR (7 downto 0);
signal ad0 : STD_LOGIC_VECTOR (9 downto 0);
--signal csn0 : STD_LOGIC;
--signal oen0 : STD_LOGIC;
signal rwn0 : STD_LOGIC;
			  
component coder
	Port ( mem_di : out  STD_LOGIC_VECTOR (7 downto 0);
           mem_do : in  STD_LOGIC_VECTOR (7 downto 0);
           mem_ad : out  STD_LOGIC_VECTOR (9 downto 0);
--           mem_csn : out  STD_LOGIC;
--           mem_oen : out  STD_LOGIC;
           mem_rwn : out  STD_LOGIC;
			  
				 clk	: in STD_LOGIC;
			    reset : in  STD_LOGIC;
           plain : in  STD_LOGIC_VECTOR (7 downto 0);
           key : in  STD_LOGIC_VECTOR (7 downto 0);
           cypher : out  STD_LOGIC_VECTOR (7 downto 0));
end component;

component fpga_mem
	port (
	a: IN std_logic_VECTOR(9 downto 0);
	d: IN std_logic_VECTOR(7 downto 0);
	clk: IN std_logic;
	we: IN std_logic;
	spo: OUT std_logic_VECTOR(7 downto 0));
end component;

--component mem1k_8bit
--	PORT ( di : IN  STD_LOGIC_VECTOR (7 DOWNTO 0); -- INPUT DATA BUS 
 --         do : OUT std_logic_VECTOR (7 DOWNTO 0); -- output data bus 
--          ad : IN  std_logic_VECTOR (9 downto 0); -- address bus 
--          ck : IN  std_logic;  -- operation on rising edge 
--          csn : IN  std_logic;  -- chip select, active at low level 
--          oen : IN  std_logic;  -- DO are Z when OEN high 
--          rwn : IN  std_logic  -- read or write operation on CK rising edge 
--        );
--end component;

begin
--mem_instanz: mem1k_8bit
--	port map( di0,do0,ad0,clk,csn0,oen0,rwn0);

--coder_instanz: coder
--	port map( di0,do0,ad0,csn0,oen0,rwn0,clk,reset,plain,key,cypher);

coder_instanz: coder
	port map( di0,do0,ad0,rwn0,clk,reset,plain,key,cypher);

fpga_mem0 : fpga_mem
		port map ( ad0,di0,clk,rwn0,do0);

end Behavioral;