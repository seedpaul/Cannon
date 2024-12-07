// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public class Lift extends SubsystemBase {

  private final Talon talon = new Talon(Constants.liftPort);
  /** Creates a new Lift. */
  public Lift() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void up(){
    talon.set(-1);

  }
  public void down(){
    talon.set(1);
  }

  public void stop(){
    talon.stopMotor();
  }


}
