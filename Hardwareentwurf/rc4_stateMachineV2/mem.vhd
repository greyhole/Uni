----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    21:10:46 08/25/2014 
-- Design Name: 
-- Module Name:    mem - Behavioral 
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

entity mem is
    Port ( di : in  STD_LOGIC_VECTOR (7 downto 0);
           do : out  STD_LOGIC_VECTOR (7 downto 0);
           ad : in  STD_LOGIC_VECTOR (9 downto 0);
           clk : in  STD_LOGIC;
           csn : in  STD_LOGIC;
           oen : in  STD_LOGIC;
           rwn : in  STD_LOGIC);
end mem;

architecture Behavioral of mem is
component mem1k_8bit
	PORT ( di : IN  STD_LOGIC_VECTOR (7 DOWNTO 0); -- INPUT DATA BUS 
          do : OUT std_logic_VECTOR (7 DOWNTO 0); -- output data bus 
          ad : IN  std_logic_VECTOR (9 downto 0); -- address bus 
          ck : IN  std_logic;  -- operation on rising edge 
          csn : IN  std_logic;  -- chip select, active at low level 
          oen : IN  std_logic;  -- DO are Z when OEN high 
          rwn : IN  std_logic  -- read or write operation on CK rising edge 
        );
end component;
begin
mem0: mem1k_8bit
	port map(di,do,ad,clk,csn,oen,rwn);
end Behavioral;

