// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;

public class Cannon extends SubsystemBase {

  public Compressor compressor1 = new Compressor(1, PneumaticsModuleType.CTREPCM);
  public Compressor compressor2 = new Compressor(2, PneumaticsModuleType.CTREPCM);
  public Compressor compressor3 = new Compressor(3, PneumaticsModuleType.CTREPCM);
  private Timer t = new Timer();
  private Boolean compress = true;

  private static final Solenoid solenoidCannon = new Solenoid(3, PneumaticsModuleType.CTREPCM,Constants.firingSolenoid);
  // private static final Relay spikeLight = new
  // Relay(Constants.spike_relay_light, Relay.Direction.kForward);
  // private static final Relay spikeFans = new Relay(Constants.spike_relay_fans,
  // Relay.Direction.kForward);

  /** Creates a new Shooter. */
  public Cannon() {
    t.start();

    compressor1.enableAnalog(0, 150);
    compressor2.enableAnalog(0, 150);
    compressor3.enableAnalog(0, 150);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void close() {
    solenoidCannon.set(false);
  }

  public void open() {

    System.out.println("fire cannon");
    solenoidCannon.set(true);// open cannon
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    solenoidCannon.set(false);// close cannon

  }

  public void toggleCompressors() {

    this.compress = !this.compress;

    //System.out.println("compress: " + this.compress);

    compressor1.disable();
    compressor2.disable();
    compressor3.disable();
  }

  // public void lightOn(){
  // spikeLight.set(Relay.Value.kOn);
  // }
  // public void lightOff(){
  // spikeLight.set(Relay.Value.kOff);
  // }

  // public void fansOn(){
  // spikeFans.set(Relay.Value.kOn);
  // }
  // public void fansOff(){

  // if(t.get() > 55.0) {
  // spikeFans.set(Relay.Value.kOff);
  // t.reset();
  // }
  // }
}
