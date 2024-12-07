// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

	    public static final class LEDConstants{
			public static final int LED_PWM_PORT = 3;
			public static final int LED_LENGTH = 100;
		
			public static final Color purple = new Color(255, 1, 255);
			public static final Color yellow = new Color(255, 128, 1);
			public static final Color orange = new Color(255, 55, 5);
			public static final Color pink = new Color(255, 50, 30);
			public static final Color green = new Color(1, 255, 1);
			public static final Color red = new Color(255, 1, 1);
		}

    public static final int leftDriveTrainPort = 0;//pwm
    public static final int rightDriveTrainPort = 1;//pwm

	public static final int turretPort = 2;//pwm
	
	public static final int liftPort = 6;//pwm

    //start xbox *****************************************
	public static final int xboxControllerDriver = 0;
	public static final int xboxControllerAssist = 1;
	
	public static final int buttonA = 1;
	public static final int buttonB = 2;
	public static final int buttonX = 3;
	public static final int buttonY = 4;
	
	public static final int buttonBumperLeft = 5;
	public static final int buttonBumperRight = 6;
	
	public static final int buttonSelect = 7;
	public static final int buttonStart = 8;
	
	public static final int rightStickY = 5;
	public static final int leftStickY = 1;
	
	public static final int rightStickX = 4;
	public static final int leftStickX = 0;
	
	public static final int rightTrigger = 3;
	public static final int leftTrigger = 2;

	public static final int rightJoystickPush = 12;
	public static final int leftJoystickPush = 11;

  //end xbox *****************************************

  public static final int firingSolenoid = 4;
	
  public static final int spike_relay_light = 1;
  public static final int spike_relay_fans = 2;
  public static final int spike_relay_speaker = 3;
  public static final int limitSwitch = 5;

}
