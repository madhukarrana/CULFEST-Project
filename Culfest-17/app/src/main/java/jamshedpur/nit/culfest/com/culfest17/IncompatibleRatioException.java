package jamshedpur.nit.culfest.com.culfest17;

/**
 * Created by Aditya on 13-12-2016.
 */

public class IncompatibleRatioException extends RuntimeException {

    private static final long serialVersionUID = 234608108593115395L;

    public IncompatibleRatioException() {
        super("Can'u perform Ken Burns effect on rects with distinct aspect ratios!");
    }
}