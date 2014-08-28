--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   21:21:15 08/25/2014
-- Design Name:   
-- Module Name:   /home/nvetter/Projekte/Uni/Hardwareentwurf/memtest/tb.vhd
-- Project Name:  memtest
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: mem
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
USE ieee.std_logic_arith.all;
USE ieee.std_logic_unsigned.all;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY tb IS
END tb;
 
ARCHITECTURE behavior OF tb IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT mem
    PORT(
         di : IN  std_logic_vector(7 downto 0);
         do : OUT  std_logic_vector(7 downto 0);
         ad : IN  std_logic_vector(9 downto 0);
         clk : IN  std_logic;
         csn : IN  std_logic;
         oen : IN  std_logic;
         rwn : IN  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal di : std_logic_vector(7 downto 0) := (others => '0');
   signal ad : std_logic_vector(9 downto 0) := (others => '0');
   signal clk : std_logic := '0';
   signal csn : std_logic := '0';
   signal oen : std_logic := '0';
   signal rwn : std_logic := '0';

 	--Outputs
   signal do : std_logic_vector(7 downto 0);

   -- Clock period definitions
   constant clk_period : time := 7.594 ns;
	subtype test is integer range 0 to 255;
	signal count : test;
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: mem PORT MAP (
          di => di,
          do => do,
          ad => ad,
          clk => clk,
          csn => csn,
          oen => oen,
          rwn => rwn
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
   stim_proc: process
   begin
      -- hold reset state for 100 ns.
		csn <= '1';
		wait for 5 ns;
		csn <= '0';
		wait for clk_period;
		rwn <= '0';
		for i in test loop
			ad <= conv_std_logic_vector(i,10);
			di <= conv_std_logic_vector(i,8);
			wait for clk_period;
		end loop;
		wait for clk_period;
		rwn <= '1';
		ad <= "0000000000";
		wait for clk_period;
		ad <= "0000000001";
		wait for clk_period;
		ad <= "0011111111";
		wait;
		-- insert stimulus here 
   end process;
END;