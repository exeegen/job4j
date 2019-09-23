package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingletonTest {

    @Test
    public void singlTrackerEnumTest(){
        SinglTrackerEnum ste1 = SinglTrackerEnum.INSTANCE;
        SinglTrackerEnum ste2 = SinglTrackerEnum.INSTANCE;
        assertThat(ste1.hashCode(), is(ste2.hashCode()));
    }

    @Test
    public void singlTrackerLazyTest(){
        SinglTrackerLazy ste1 = SinglTrackerLazy.getInstance();
        SinglTrackerLazy ste2 = SinglTrackerLazy.getInstance();
        assertThat(ste1.hashCode(), is(ste2.hashCode()));
    }

    @Test
    public void singlTrackerLazyEager(){
        SinglTrackerEager ste1 = SinglTrackerEager.getInstance();
        SinglTrackerEager ste2 = SinglTrackerEager.getInstance();
        assertThat(ste1.hashCode(), is(ste2.hashCode()));
    }

    @Test
    public void singlTrackerLazyHolder(){
        SinglTrackerHolder ste1 = SinglTrackerHolder.getInstance();
        SinglTrackerHolder ste2 = SinglTrackerHolder.getInstance();
        assertThat(ste1.hashCode(), is(ste2.hashCode()));
    }

}
