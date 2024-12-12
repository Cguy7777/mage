package mage.target.common;

import mage.abilities.dynamicvalue.DynamicValue;
import mage.filter.FilterPermanent;
import mage.filter.common.FilterCreaturePermanent;

/**
 * @author North
 */
public class TargetCreaturePermanentAmount extends TargetPermanentAmount {

    private static final FilterCreaturePermanent defaultFilter = new FilterCreaturePermanent("target creatures");

    /**
     * <b>IMPORTANT</b>: Use more specific constructor if {@code amount} is not always the same number!<br>
     * {@code minNumberOfTargets} defaults to zero for {@code amount} > 3, otherwise to one, in line with typical templating.<br>
     * {@code maxNumberOfTargets} defaults to {@code amount}.<br>
     * {@code filter} defaults to all creature permanents. ("target creatures")
     *
     * @see TargetCreaturePermanentAmount#TargetCreaturePermanentAmount(int, int, int, FilterPermanent)
     */
    public TargetCreaturePermanentAmount(int amount) {
        this(amount, defaultFilter);
    }

    /**
     * <b>IMPORTANT</b>: Use more specific constructor if {@code amount} is not always the same number!<br>
     * {@code minNumberOfTargets} defaults to zero for {@code amount} > 3, otherwise to one, in line with typical templating.<br>
     * {@code maxNumberOfTargets} defaults to {@code amount}.
     *
     * @see TargetCreaturePermanentAmount#TargetCreaturePermanentAmount(int, int, int, FilterPermanent)
     */
    public TargetCreaturePermanentAmount(int amount, FilterPermanent filter) {
        this(amount, amount > 3 ? 0 : 1, amount, filter);
    }

    /**
     * {@code filter} defaults to all creature permanents. ("target creatures")
     *
     * @see TargetCreaturePermanentAmount#TargetCreaturePermanentAmount(int, int, int, FilterPermanent)
     */
    public TargetCreaturePermanentAmount(int amount, int minNumberOfTargets, int maxNumberOfTargets) {
        this(amount, minNumberOfTargets, maxNumberOfTargets, defaultFilter);
    }

    /**
     * @param amount             Amount of stuff (e.g. damage, counters) to distribute.
     * @param minNumberOfTargets Minimum number of targets.
     * @param maxNumberOfTargets Maximum number of targets. If no lower max is needed, set to {@code amount}.
     * @param filter             Filter for creatures that something will be distributed amongst.
     */
    public TargetCreaturePermanentAmount(int amount, int minNumberOfTargets, int maxNumberOfTargets, FilterPermanent filter) {
        super(amount, minNumberOfTargets, maxNumberOfTargets, filter);
    }

    /**
     * {@code filter} defaults to all creature permanents. ("target creatures")
     *
     * @see TargetCreaturePermanentAmount#TargetCreaturePermanentAmount(DynamicValue, FilterPermanent)
     */
    public TargetCreaturePermanentAmount(DynamicValue amount) {
        this(amount, defaultFilter);
    }

    /**
     * Minimum number of targets will be zero, and max will be set to Integer.MAX_VALUE.
     *
     * @param amount Amount of stuff (e.g. damage, counters) to distribute.
     * @param filter Filter for creatures that something will be distributed amongst.
     */
    public TargetCreaturePermanentAmount(DynamicValue amount, FilterPermanent filter) {
        super(amount, 0, filter);
    }

    private TargetCreaturePermanentAmount(final TargetCreaturePermanentAmount target) {
        super(target);
    }

    @Override
    public TargetCreaturePermanentAmount copy() {
        return new TargetCreaturePermanentAmount(this);
    }
}
