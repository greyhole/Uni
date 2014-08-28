--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   23:36:54 08/26/2014
-- Design Name:   
-- Module Name:   /home/nvetter/rc4/rc4_tb.vhd
-- Project Name:  rc4
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: rc4
-- 
-- Dependencies:
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
--
-- Notes: 
-- This testbench has been automatically generated using types std_logic and
-- std_logic_vector for the ports of the unit under test.  Xilinx recommends
-- that these types always be used for the top-level I/O of a design in order
-- to guarantee that the testbench will bind correctly to the post-implementation 
-- simulation model.
--------------------------------------------------------------------------------
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY rc4_tb IS
END rc4_tb;
 
ARCHITECTURE behavior OF rc4_tb IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT rc4
    PORT(
         key : IN  std_logic_vector(7 downto 0);
         plain : IN  std_logic_vector(7 downto 0);
         reset : IN  std_logic;
         clk : IN  std_logic;
         cypher : OUT  std_logic_vector(7 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal key : std_logic_vector(7 downto 0) := (others => '0');
   signal plain : std_logic_vector(7 downto 0) := (others => '0');
   signal reset : std_logic := '0';
   signal clk : std_logic := '0';
	
 	--Outputs
   signal cypher : std_logic_vector(7 downto 0);

   -- Clock period definitions
   constant clk_period : time := 4 ns;
	type key_array is ARRAY (natural range <>) of std_logic_vector(7 downto 0);
	constant key_data : key_array := ("01010110","01001000","01000100","01001100");
	constant plain_data : key_array := ("01010110","01001000","01000100","01001100");
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: rc4 PORT MAP (
          key => key,
          plain => plain,
          reset => reset,
          clk => clk,
          cypher => cypher
        );

   -- Clock process definitions
   clk_process :process
   begin
		clk <= '0';
		wait for clk_period/2;
		clk <= '1';
		wait for clk_period/2;
   end process;
 

   -- Stimulus process
   key_proc: process
   begin		
      -- hold reset state for 100 ns.

		wait for clk_period*260;
		For i in 0 to 64 loop
			For j in key_data'RANGE LOOP
             key <= key_data(j);
             wait for clk_period*5;
         end LOOP;
		end loop;
		-- insert stimulus here 
      wait;
   end process;
	plain_proc: process
	begin
		wait for 7 us;
			For k in 0 to 64 loop
				For l in plain_data'RANGE LOOP
					plain <= plain_data(l);
					wait for clk_period*5;
				end LOOP;
			end loop;
		plain <= "00000000";
		wait;
	end process;


END;
