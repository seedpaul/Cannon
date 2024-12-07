// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.Constants;
import frc.robot.commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final XboxController driver = new XboxController(Constants.xboxControllerDriver);
  public final Drivetrain driveTrain = new Drivetrain();
  public final Turret turret = new Turret();
  public final Lift lift = new Lift();
  public Cannon m_cannon;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer(Cannon in_Cannon) {
    // Configure the button bindings
    m_cannon = in_Cannon;
    configureButtonBindings();
    

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton buttonBumperRight = new JoystickButton(driver,Constants.buttonBumperRight);
    JoystickButton buttonBumperLeft = new JoystickButton(driver,Constants.buttonBumperLeft);

    buttonBumperRight.onTrue((edu.wpi.first.wpilibj2.command.Command)new turretRight(turret));
    buttonBumperRight.onFalse((edu.wpi.first.wpilibj2.command.Command)new turretStop(turret));

    buttonBumperLeft.onTrue((edu.wpi.first.wpilibj2.command.Command)new turretLeft(turret));
    buttonBumperLeft.onFalse((edu.wpi.first.wpilibj2.command.Command)new turretStop(turret));

    JoystickButton buttonY = new JoystickButton(driver,Constants.buttonY);
    JoystickButton buttonA = new JoystickButton(driver,Constants.buttonA);
    JoystickButton buttonX = new JoystickButton(driver, Constants.buttonX);

    JoystickButton buttonStart = new JoystickButton(driver, Constants.buttonStart);

    buttonY.onTrue((edu.wpi.first.wpilibj2.command.Command)new liftUp(lift));
    buttonY.onFalse((edu.wpi.first.wpilibj2.command.Command)new liftStop(lift));

    buttonA.onTrue((edu.wpi.first.wpilibj2.command.Command)new liftDown(lift));
    buttonA.onFalse((edu.wpi.first.wpilibj2.command.Command)new liftStop(lift));
    
    buttonX.onTrue(new fireCannon(m_cannon));
    buttonX.onFalse(new closeCannon(m_cannon));//shut it to rebuild pressure

    buttonStart.onTrue(new toggleCompressor(m_cannon));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
