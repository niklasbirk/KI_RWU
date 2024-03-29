package machine_learning;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Vector
{
    private final List<Double> values;

    public Vector(int dim)
    {
        this(IntStream.range(0, dim)
                .mapToDouble(i -> 0d)
                .toArray());
    }

    public Vector(double... value)
    {
        this(Arrays.stream(value)
                .boxed()
                .collect(Collectors.toList()));
    }

    public Vector(List<Double> values)
    {
        this.values = values;
    }

    public int dimension()
    {
        return this.values.size();
    }

    public Vector add(Vector b)
    {
        checkEqualDimensions(b);
        return new Vector(IntStream.range(0,
                this.dimension())
                .mapToObj(i -> this.get(i) + b.get(i))
                .collect(Collectors.toList())
        );

    }

    public Vector subtract(Vector b)
    {
        checkEqualDimensions(b);
        return new Vector(IntStream.range(0,
                this.dimension())
                .mapToObj(i -> this.get(i) - b.get(i))
                .collect(Collectors.toList())
        );
    }

    public double dot(Vector b)
    {
        checkEqualDimensions(b);
        return IntStream.range(0,
                this.dimension())
                .mapToDouble(i -> this.get(i) * b.get(i))
                .sum();
    }

    public double norm()
    {
        return Math.sqrt(IntStream.range(0,
                this.dimension())
                .mapToDouble(i -> this.get(i) * this.get(i))
                .sum());
    }

    public double distance(Vector b)
    {
        return Math.sqrt(IntStream.range(0,
                this.dimension())
                .mapToDouble(i -> (this.get(i) - b.get(i)) * (this.get(i) - b.get(i)))
                .sum());
    }

    public Vector divide(double div)
    {
        return new Vector(IntStream.range(0, this.dimension())
                .mapToObj(i -> this.values.get(i) / div)
                .collect(Collectors.toCollection(ArrayList::new)));
    }

    public double get(int index)
    {
        return this.values.get(index);
    }

    public Vector decreasedDimension()
    {
        return new Vector(this.values.subList(0, this.dimension()-1));
    }

    public Vector normalized()
    {
        return this.divide(this.norm());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Vector vector = (Vector) o;

        return Objects.equals(values, vector.values);
    }

    @Override
    public int hashCode()
    {
        return values != null ? values.hashCode() : 0;
    }

    @Override
    public String toString()
    {
        return this.values.toString();
    }

    private void checkEqualDimensions(Vector b)
    {
        if (this.dimension() != b.dimension())
            throw new IllegalArgumentException("Dimensions must be equal");
    }
}
