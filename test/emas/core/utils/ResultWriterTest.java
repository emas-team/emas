package emas.core.utils;

import emas.agents.Agent;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultWriterTest {
    private ResultWriter resultWriter;

    @Before
    public void setUp() {
        resultWriter = new ResultWriter();
    }

    @Test
    public void testSaveResults() throws Exception {

    }

    @Test
    public void testSaveGeneration() throws Exception {
        List<Agent> agentList = new ArrayList<>();
        Agent agent = mock(Agent.class);
        double expected = 10.;
        when(agent.evaluate()).thenReturn(expected);
        agentList.add(agent);

        resultWriter.saveGeneration(agentList);

        Field f = resultWriter.getClass().getDeclaredField("generations");
        f.setAccessible(true);
        List generation = (List) f.get(resultWriter);

        assertTrue(generation.size() > 0);
        Double actual = (Double) generation.get(0);
        assertEquals((Object)expected, actual);
    }

    @Test
    public void testGetBest() throws Exception {
        List<Agent> agentList = new ArrayList<>();
        double value1 = 10.;
        double value2 = 5.76;
        Agent agent1 = mock(Agent.class);
        Agent agent2 = mock(Agent.class);
        when(agent1.evaluate()).thenReturn(value1);
        when(agent2.evaluate()).thenReturn(value2);
        agentList.add(agent1);
        agentList.add(agent2);

        assertEquals(5.76, resultWriter.getBest(agentList), 0.01);
    }
}