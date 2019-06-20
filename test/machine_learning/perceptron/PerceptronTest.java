package machine_learning.perceptron;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PerceptronTest
{
    List<Vector> positives;
    List<Vector> negatives;

    @BeforeAll
    void initLearnData()
    {
        this.positives = new ArrayList<>(List.of(
                new Vector(List.of(8d, 4d)),
                new Vector(List.of(8d, 6d)),
                new Vector(List.of(9d, 2d)),
                new Vector(List.of(9d, 5d)))
        );

        this.negatives = new ArrayList<>(List.of(
                new Vector(List.of(6d, 1d)),
                new Vector(List.of(7d, 3d)),
                new Vector(List.of(8d, 2d)),
                new Vector(List.of(9d, 0d)))
        );
    }

    @Test
    void shouldClassifyCorrect()
    {
        new Perceptron().learn(this.positives, this.negatives);
    }
}