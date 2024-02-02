package UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import Management.EnergyManagementSystem;

class EnergyManagementSystemTest {

	@Test
    void testDisplayAvailableEnergySources() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        EnergyManagementSystem.displayAvailableEnergySources();

        assertTrue(outputStream.toString().contains("Available energy sources"));

        System.setOut(System.out);
    }

    @Test
    void testAddEnergySource() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        EnergyManagementSystem.addEnergySource("Nuclear");

        assertTrue(outputStream.toString().contains("Nuclear will be added to energy sources"));
        assertTrue(EnergyManagementSystem.availableEnergySources.contains("Nuclear"));

        System.setOut(System.out);
    }

    @Test
    void testRemoveEnergySource() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        EnergyManagementSystem.removeEnergySource("Solar");

        assertTrue(outputStream.toString().contains("Solar has been removed from the available energy sources."));
        assertFalse(EnergyManagementSystem.availableEnergySources.contains("Solar"));

        System.setOut(System.out);
    }

}
