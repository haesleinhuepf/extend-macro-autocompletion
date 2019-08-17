package net.haesleinhuepf.fiji.macro;

/**
 * This is a suggested interface all macro extending plugins should implement.
 * Change it according to your needs.
 *
 * @author haesleinhuepf
 *         August 2019
 */
public interface MyMacroExtensionDescriptor {
    void runFromMacro(Object[] parameters);
    int[] parameterTypes();
    String description();
    String parameters();
}
