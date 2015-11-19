package creatures;

import org.junit.*;

import creatures.visual.CreatureSimulator;

import static org.junit.Assert.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import simulator.EnergyPoint;
import static org.mockito.Mockito.*;

public class EnergySearchingCreatureTest {

	private CreatureSimulator environment = null;
	private EnergySearchingCreature esc = null;
	private EnergyPoint ep = null;
	
	private static final double COLOR_FACTOR = 2.55;
	
	private static final double EPSILON = 0.5; 
	
	@Before
	public void setup() {
		environment = new CreatureSimulator(new Dimension(500, 500));
		esc = new EnergySearchingCreature(environment, new Point2D.Double(0,0), 2, Math.PI, Color.RED);
	}
	
	@After
	public void pullDown() {
		environment = null;
		esc = null;
	}
	
/*	@Test 
	public void testCyanify() {
		assertEquals(Color.RED, esc.getColor());
		double energyLost = EnergySearchingCreature.reduceEnergyFactor;
		esc.act();//esc.setEnergy(esc.getEnergy() - energyLost);
		assertEquals(AbstractCreature.MAX_ENERGY - energyLost, esc.getEnergy(), EPSILON);
		Color newColor = esc.getColor();
		assertEquals(255 - energyLost*COLOR_FACTOR, newColor.getRed(), EPSILON);
		assertEquals(energyLost*COLOR_FACTOR, newColor.getGreen(), EPSILON);
		assertEquals(energyLost * COLOR_FACTOR, newColor.getBlue(), EPSILON);
	}*/
	
	@Test
	public void testCyanify() {
		//System.out.println(0 + 0.2 * 2.55);
		int num = 1;
		Color oc = new Color(255,0,0);
		Color nc = oc;
		for(int i = 0; i < num; i++ ) {
			nc = EnergySearchingCreature.cyanify(nc);
			
		}
		System.out.println(nc);
		double energyLost = EnergySearchingCreature.reduceEnergyFactor;
		assertEquals((int)Math.round(oc.getRed() - num*energyLost*COLOR_FACTOR), nc.getRed(), EPSILON);
	}

}