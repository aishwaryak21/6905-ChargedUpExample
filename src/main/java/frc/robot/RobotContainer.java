// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.opencv.core.Point;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.DriveSubsystem;

public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem(); 
  CommandXboxController controller = new CommandXboxController( 0); 
  public RobotContainer() {
    configureBindings();

    driveSubsystem.setDefaultCommand(getAutonomousCommand());
      Commands.run(()-> driveSubsystem.arcadeDrive(-controller.getLeftY() * 0.5, controller.getRightX() * 0.5)); 
    }


  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
