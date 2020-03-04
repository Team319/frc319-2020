/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.models.RobotMode;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Serializer;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tower;
import frc.robot.subsystems.Turret;
import frc.robot.commands.autos.DriveForwardFiveFeet;
import frc.robot.commands.autos.SneakyPete;
import frc.robot.commands.drivetrain.BobDrive;
import frc.robot.commands.autos.ShootAndDontMove;
import frc.robot.commands.autos.ShootAndPushAuto;
import frc.robot.commands.autos.BasicShootAuto;
import frc.robot.commands.autos.DoNothing;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  SendableChooser<Command> autoChooser;
  Command autonomousCommand;

  public static Shooter shooter = new Shooter();
  public static Collector collector = new Collector();
  public static Drivetrain drivetrain = new Drivetrain();
  public static Serializer serializer = new Serializer();
  public static Climber climber = new Climber();
  public static Tower tower = new Tower();
  public static Limelight limelight = new Limelight();
  public static Turret turret = new Turret();
  public static Pneumatics pneumatics = new Pneumatics();
  public static OI oi;
  public static RobotMode robotMode = RobotMode.Normal;

  private Command m_autonomousCommand;
  private Command m_teleopCommand = new BobDrive();
  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    oi = new OI();
    limelight.enableSecondaryCameraStream();

    SmartDashboard.putNumber("Auto Delay", 0);
    SmartDashboard.putNumber("Auto Drive Time", 1);

    autoChooser = new SendableChooser<Command>();
    autoChooser.setDefaultOption("Do Nothing", new DoNothing());
    // autoChooser.addOption("Sneaky Pete", "SneakyPete");
    // autoChooser.addOption("Off Line", "DriveForwardFiveFeet");
    autoChooser.addOption("Litteraly Just Shoot Thank You", new ShootAndDontMove());
    autoChooser.setDefaultOption("Shoot And Move", new BasicShootAuto());
    autoChooser.addOption("Shoot and Push", new ShootAndPushAuto());

    SmartDashboard.putData("Autonomous Chooser", autoChooser);

    limelight.setLedModeOff();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    limelight.enableSecondaryCameraStream();
    limelight.setLedModeOff();
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    limelight.enableSecondaryCameraStream();
    m_autonomousCommand = autoChooser.getSelected();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    limelight.enableSecondaryCameraStream();
  }

  @Override
  public void teleopInit() {
    limelight.enableSecondaryCameraStream();

    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    m_teleopCommand.schedule();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    limelight.enableSecondaryCameraStream();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
