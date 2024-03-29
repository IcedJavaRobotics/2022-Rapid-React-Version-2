// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Buttons
    public static final int ARMS_UP_BUTTON = 4;
    public static final int ARMS_DOWN_BUTTON = 6;
    public static final int OUTTAKE_BUTTON = 5;
    public static final int INTAKE_BUTTON = 3;
    public static final int ELEVATOR_UP_BUTTON = 9;
    public static final int ELEVATOR_DOWN_BUTTON = 10;
    public static final int SHOOTER_BUTTON = 1;
    public static final int CLIMBER_UP_BUTTON = 7;
    public static final int CLIMBER_DOWN_BUTTON = 8;
    public static final int BLINKIN_BUTTON = 11;
    public static final int INTAKE_SHOOT = 12;

    //DriveTrain
    public static final int FRONT_LEFT_TALON = 3;
    public static final int BACK_LEFT_TALON = 2;
    public static final int FRONT_RIGHT_TALON = 1;
    public static final int BACK_RIGHT_TALON = 4;
    public static final int ROTATIONAL_CONSTANT = 2048;
    public static final double RAMP_UP_TIME = 3;                // in seconds
    public static final int AUTO_DISTANCE_FORWARD = 30;         // in inches
    public static final int AUTO_DISTANCE_BACKWARDS = 30;       // in inches
    public static final double ELEVATOR_TIME = 5;               // in seconds

    //Controllers
    //public static final int CONTROLLER = 1;
    public static final int JOYSTICK = 0;
    public static final int JOYSTICK2 = 1;
        // ^ these indicate the spot used on the driverstation ^
    public static final double DEADZONE = 0.2;

    //Intake
    public static final int INTAKE_VICTOR = 11;
    public static final double INTAKE_SPEED = 0.8;

    //Arms
    public static final int LEFT_ARM = 5;
    public static final int RIGHT_ARM = 6;
    public static final double ARM_SPEED = 0.5;

    //Elevator
    public static final int ELEVATOR_VICTOR = 10;
    public static final double ELEVATOR_SPEED = 0.6;

    //Shooter
    public static final int BLINKIN_SPARK = 0;          //blinkin
    public static final int SHOOTER_VICTOR = 7;          //tbd
    public static final double SHOOTER_SPEED = 0.5;

    //Climber
    public static final int CLIMBER_LEFT_MOTOR = 8;
    public static final int CLIMBER_RIGHT_MOTOR = 9;
    public static final double CLIMBER_SPEED = 0.2;
    public static final int CLIMBER_LEFT_LIMIT_SWITCH = 6;
    public static final int CLIMBER_RIGHT_LIMIT_SWITCH = 7;

}
