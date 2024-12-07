// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  
  private final Talon left = new Talon(Constants.leftDriveTrainPort);
  private final Talon right = new Talon(Constants.rightDriveTrainPort);

  public final DifferentialDrive roboDrive = new DifferentialDrive(left, right);

  /** Creates a new drivetrain. */
  public Drivetrain() {

    roboDrive.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcade(final XboxController driver) {

    final double turn = -driver.getRawAxis(Constants.leftStickY);
    final double speed = driver.getRawAxis(Constants.rightStickX);

    // turn = turn * 0.65;

    roboDrive.arcadeDrive(speed, turn, true);
  }
}
