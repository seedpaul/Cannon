// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;

public class Turret extends SubsystemBase {

  private final CANSparkMax SparkMaxTurret = new CANSparkMax(30, CANSparkLowLevel.MotorType.kBrushless);  

  /** Creates a new Turret. */
  public Turret() {

    SparkMaxTurret.restoreFactoryDefaults();
    SparkMaxTurret.setIdleMode(IdleMode.kBrake);
    SparkMaxTurret.enableVoltageCompensation(12);
    SparkMaxTurret.setSmartCurrentLimit(10, 65, 100);

  }

  @Override
  public void periodic() {

  }

  public void left() {
    SparkMaxTurret.set(-0.3);

  }

  public void right() {
    SparkMaxTurret.set(0.3);
  }

  public void stop() {
    SparkMaxTurret.stopMotor();
  }

}