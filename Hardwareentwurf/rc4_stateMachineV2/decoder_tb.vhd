--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   22:05:36 08/26/2014
-- Design Name:   
-- Module Name:   /home/nvetter/rc4/decoder_tb.vhd
-- Project Name:  rc4
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: coder
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
 
ENTITY decoder_tb IS
END decoder_tb;
 
ARCHITECTURE behavior OF decoder_tb IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT coder
    PORT(
         mem_di : OUT  std_logic_vector(7 downto 0);
         mem_do : IN  std_logic_vector(7 downto 0);
         mem_ad : OUT  std_logic_vector(9 downto 0);
         mem_csn : OUT  std_logic;
         mem_oen : OUT  std_logic;
         mem_rwt : OUT  std_logic;
         clk : IN  std_logic;
         reset : IN  std_logic;
         plain : IN  std_logic_vector(7 downto 0);
         key : IN  std_logic_vector(7 downto 0);
         cypher : OUT  std_logic_vector(7 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal mem_do : std_logic_vector(7 downto 0);
   signal clk : std_logic := '0';
   signal reset : std_logic := '0';
   signal plain : std_logic_vector(7 downto 0) := (others => '0');
   signal key : std_logic_vector(7 downto 0) := (others => '0');

 	--Outputs
   signal mem_di : std_logic_vector(7 downto 0) := (others => '0');
   signal mem_ad : std_logic_vector(9 downto 0);
   signal mem_csn : std_logic;
   signal mem_oen : std_logic;
   signal mem_rwt : std_logic;
   signal cypher : std_logic_vector(7 downto 0);

   -- Clock period definitions
   constant clk_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: coder PORT MAP (
          mem_di => mem_di,
          mem_do => mem_do,
          mem_ad => mem_ad,
          mem_csn => mem_csn,
          mem_oen => mem_oen,
          mem_rwt => mem_rwt,
          clk => clk,
          reset => reset,
          plain => plain,
          key => key,
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
   stim_proc: process
   begin		
      -- hold reset state for 100 ns.
      reset <= '1';
		wait for 100 ns;	
		reset <= '0';
      wait for clk_period*10;

      -- insert stimulus here 

      wait;
   end process;

END;
