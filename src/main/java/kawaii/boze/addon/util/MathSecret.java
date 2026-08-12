package kawaii.boze.addon.util;

//very secrete!!!!!!!!!!!!!!!!!!!!!!!!
public class MathSecret {

    public static float transform(Double seed, float multiplier) {
        return (float) (seed * multiplier);
    }

    public static float RandomTransform(Double seed) {
        return (float) (seed * 77769420 * Math.random());
    }
}
