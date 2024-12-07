// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.XboxController;

public class arcadeDrive extends Command {

  private final Drivetrain m_driveTrain;
  private final XboxController m_driverController;

  /** Creates a new arcadeDrive. */
  public arcadeDrive(Drivetrain in_driveTrain, XboxController in_driverController) {
    m_driveTrain = in_driveTrain;
    m_driverController = in_driverController;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.arcade(m_driverController);
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
