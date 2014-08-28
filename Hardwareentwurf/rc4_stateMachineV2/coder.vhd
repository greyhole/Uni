----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    19:17:22 08/26/2014 
-- Design Name: 
-- Module Name:    coder - Behavioral 
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
use ieee.std_logic_unsigned.all;
use ieee.numeric_std.all;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity coder is
    Port ( mem_di : out  STD_LOGIC_VECTOR (7 downto 0) := (others => '0');
           mem_do : in  STD_LOGIC_VECTOR (7 downto 0);
           mem_ad : out  STD_LOGIC_VECTOR (9 downto 0) := (others => '0');
--           mem_csn : out  STD_LOGIC := '1';
--           mem_oen : out  STD_LOGIC := '0';
           mem_rwn : out  STD_LOGIC := '0'; --set '1' for ASIC_MEM
			  
			  clk	: in STD_LOGIC;
			  reset : in  STD_LOGIC;
           plain : in  STD_LOGIC_VECTOR (7 downto 0);
           key : in  STD_LOGIC_VECTOR (7 downto 0);
           cypher : out  STD_LOGIC_VECTOR (7 downto 0));
end coder;

architecture Behavioral of coder is
signal stat : std_logic_vector(2 downto 0) := "000";
signal crypt,freest : std_logic := '0';
signal i,count : std_logic_vector(7 downto 0) := (others => '0');

begin
big: process(clk)
variable j,si,sj : std_logic_vector(7 downto 0) := (others => '0');
variable j_ad : std_logic_vector(9 downto 0) := (others => '0');
variable t : std_logic_vector(7 downto 0) := (others => 'X');
begin
	if rising_edge(clk) then
		if reset = '1' then
			count <= (others => '0');
			i <= (others => '0');
			j := (others => '0');
			stat <= "000";
			crypt <= '0';
		elsif crypt = '0' then
			case stat is
				when "000" =>
					mem_rwn <= '1'; -- '0' for ASIC_MEM
					mem_ad <= ("00" & count);
					mem_di <= count;
					count <= count + 1;
					if count = "11111111" then 
						stat <= "001";
					end if;
				when "001" =>
					mem_rwn <= '0';
					mem_ad <= ("00" & i);
					stat <= "010";
				when "010" =>
					if key /= "00000000" then
						si := mem_do;
						j := si + j + key ;
						mem_ad <= ("00" & j);
						stat <= "011";
					end if;
				when "011" =>
					sj := mem_do;
					mem_rwn <= '1';
					mem_di <= si;
					stat <= "100";
				when "100" =>
					mem_rwn <= '1';
					mem_ad <= ("00" & i);
					mem_di <= sj;
					stat <= "101";
				when "101" =>
					if i /= "11111111" then
						i <= i + 1;
						stat <= "001";
					else
						crypt <= '1';
						i <= (others => '0');
						mem_rwn <= '0';
						mem_ad <= (others => '0');
						stat <= "010";
					end if;
				when others =>
					mem_di <= "00000000";
					mem_ad <= "0000000000";
					cypher <= "XXXXXXXX";
			end case;
		else
			case stat is
				when "001" =>
					mem_rwn <= '0';
					mem_ad <= ("00" & i);
					stat <= "010";
					cypher <= plain xor mem_do;
				when "010" =>
					if plain /= "00000000" then 
						si := mem_do;
						j := si + j;
						mem_ad <= ("00" & j);
						stat <= "011";
					end if;
				when "011" =>
					sj := mem_do;
					mem_rwn <= '1';
					mem_di <= si;
					stat <= "100";
				when "100" =>
					mem_rwn <= '1';
					mem_ad <= ("00" & i);
					mem_di <= sj;
					stat <= "101";
				when "101" =>
					mem_rwn <= '0';
					t := (si + sj);
					mem_ad <= ("00" & t);
					i <= i + 1;
					stat <= "001";
				when others =>
					mem_di <= "00000000";
					mem_ad <= "0000000000";
					cypher <= "XXXXXXXX";
			end case;
		end if;
	end if;
end process;

end Behavioral;