package emas.agents;

import com.google.common.collect.Iterators;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class IslandTest {

    @Test
    public void testRemoveDeadAgents() throws Exception {
        Island island = new Island();
        int start = Iterators.size(island.iterator());

        Agent deadAgent = mock(Agent.class);
        when(deadAgent.getEnergy()).thenReturn(0);

        island.addAgent(deadAgent);
        island.removeDeadAgents();
        int end = Iterators.size(island.iterator());
        assertTrue(start == end);
    }

    @Test
    public void testAddAgent() throws Exception {
        Island island = new Island();
        int start = Iterators.size(island.iterator());

        Agent deadAgent = mock(Agent.class);
        when(deadAgent.getEnergy()).thenReturn(10);

        island.addAgent(deadAgent);
        island.removeDeadAgents();
        int end = Iterators.size(island.iterator());
        assertTrue(start == end-1);
    }

    @Test
    public void testRemoveAgent() throws Exception {
        Island island = new Island();
        int start = Iterators.size(island.iterator());

        Agent agent = mock(Agent.class);

        island.addAgent(agent);
        island.removeAgent(agent);
        island.removeDeadAgents();

        int end = Iterators.size(island.iterator());

        assertTrue(start == end);
    }
}