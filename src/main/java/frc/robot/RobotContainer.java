// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.OuttakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.ArmsUpCommand;
import frc.robot.commands.BlinkinCommand;
import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.ArmsDownCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ArmsSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
  private final ArmsSubsystem armsSubsystem = new ArmsSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  XboxController xboxController = new XboxController(Constants.CONTROLLER);
  Joystick flightStick = new Joystick(Constants.JOYSTICK);

  // private final ExampleCommand m_autoCommand = new ExampleCommand(talonFXTestSubsystem);
  private final ExampleCommand m_autoCommand = new ExampleCommand(driveTrainSubsystem, shooterSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings

    configureButtonBindings(); {
      
      new JoystickButton(flightStick, 1) //1 is the trigger
      .whileHeld(new ShooterCommand(shooterSubsystem));

      new JoystickButton(flightStick, 3)
      .whileHeld(new OuttakeCommand(intakeSubsystem));

      new JoystickButton(flightStick, 4)
      .whileHeld(new ArmsUpCommand(armsSubsystem));

      new JoystickButton(flightStick, 5)
      .whileHeld(new IntakeCommand(intakeSubsystem));

      new JoystickButton(flightStick, 6)
      .whileHeld(new ArmsDownCommand(armsSubsystem));

      new JoystickButton(flightStick, 9)
      .whileHeld(new ElevatorUpCommand(elevatorSubsystem));

      new JoystickButton(flightStick, 10)
      .whileHeld(new ElevatorDownCommand(elevatorSubsystem));

      new JoystickButton(flightStick, 11) //Fill in number right now
      .whileHeld(new BlinkinCommand(shooterSubsystem));      

    }

    driveTrainSubsystem.setDefaultCommand(
      new RunCommand(() -> driveTrainSubsystem.mecanumDrive(getJoystickX(), getJoystickY(), getJoystickTwist()), driveTrainSubsystem)
    );

  }

  private double deadZoneMod(double val) {
    if (Math.abs(val) <= Constants.DEADZONE) {
      return 0;
    } else {
      return ((val -0.2) * 1.25) ;
    }
  }

  /*
  public double getControllerRightX() {
    if ( xboxController != null ) {
      return deadZoneMod(xboxController.getRightX());
    } else {
      return 0;
    }
  }

  public double getControllerLeftX() {
    if (xboxController != null ) {
      return deadZoneMod(xboxController.getLeftX());
    } else {
      return 0;
    }
  }

  public double getControllerRightY() {
    if ( xboxController != null ) {
      return deadZoneMod(xboxController.getRightY());
    } else {
      return 0;
    }
    
  }
  */

  public double getJoystickX() {
    if ( flightStick != null ) {
      return deadZoneMod(flightStick.getX());
    } else {
      return 0;
    }
  }

  public double getJoystickY() {
    if ( flightStick != null ) {
      return deadZoneMod(flightStick.getY());
    } else {
      return 0;
    }
  }

  public double getJoystickTwist() {
    if ( flightStick != null ) {
      return deadZoneMod(flightStick.getTwist());
    } else {
      return 0;
    }
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
