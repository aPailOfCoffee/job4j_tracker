package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenComparatorByDescName() {
        Comparator<Job> cmpNameDesc = new JobDescByName();
        int rsl = cmpNameDesc.compare(
                new Job("A task", 1),
                new Job("B bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByAscName() {
        Comparator<Job> cmpNameAsc = new JobAscByName();
        int rsl = cmpNameAsc.compare(
                new Job("A task", 1),
                new Job("B bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByDescPriority() {
        Comparator<Job> cmpPriorDesc = new JobDescByPriority();
        int rsl = cmpPriorDesc.compare(
                new Job("A task", 0),
                new Job("A task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByAscPriority() {
        Comparator<Job> cmpPriorAsc = new JobAscByPriority();
        int rsl = cmpPriorAsc.compare(
                new Job("A task", 0),
                new Job("A task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A task", 1),
                new Job("B task", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByDescPriorityAndDescName() {
        Comparator<Job> cmpPriorityName = new JobDescByPriority()
                .thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("A task", 1),
                new Job("B task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B task", 0),
                new Job("A task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByAscPriorityAndAscName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority()
                .thenComparing(new JobAscByName());
        int rsl = cmpPriorityName.compare(
                new Job("A task", 0),
                new Job("B task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A task", 0),
                new Job("A task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByAscPriorityAndDescName() {
        Comparator<Job> cmpPriorityName = new JobAscByPriority()
                .thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("B task", 1),
                new Job("A task", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}