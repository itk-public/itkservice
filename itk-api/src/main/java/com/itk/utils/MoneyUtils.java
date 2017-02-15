package com.itk.utils;

import java.math.BigDecimal;

/**
 * Created by zhouhui on 2017/2/14.
 */
public final class MoneyUtils {

    private MoneyUtils() {
        // prevent instantiation
    }

    public static BigDecimal newMoney(Long number)
    {
        BigDecimal bd = new BigDecimal(number);

        return setScale(bd);
    }
    public static BigDecimal newMoney(String number)
    {
        BigDecimal bd = new BigDecimal(number);

        return setScale(bd);
    }
    public static BigDecimal newMoney(float number)
    {
        BigDecimal bd = new BigDecimal(number);

        return setScale(bd);
    }

    public static BigDecimal setScale(BigDecimal bd)
    {
        return bd.setScale(Constant.DEFAULT_SCALE, Constant.DEFAULT_ROUND);
    }

    public static int displayInt(BigDecimal bd)
    {
        return MoneyUtils.multiply(bd, Constant.HUNDREDDECIMAL).intValue();
    }

    public static BigDecimal fromDisplayInt(int bd)
    {
        return divide(newMoney(bd),Constant.HUNDREDDECIMAL);
    }

    public static String displayMoney(BigDecimal bd)
    {
        String template = "￥ %s";
        return String.format(template, bd.toString());
    }

    public static BigDecimal add(final BigDecimal first, final  BigDecimal second)
    {
        if ( first == null || notNull(first).equals(BigDecimal.ZERO) ) {
            return notNull(second);
        } else if ( second == null || notNull(second).equals(BigDecimal.ZERO) ) {
            return notNull(first);
        } else  {
            return first.add(second).setScale(Constant.DEFAULT_SCALE, Constant.DEFAULT_ROUND);
        }
    }

    public static BigDecimal substract(BigDecimal first,  BigDecimal second)
    {
        if(first == null)
            first = BigDecimal.ZERO;
        if(second == null)
            second = BigDecimal.ZERO;
        return first.subtract(second).setScale(Constant.DEFAULT_SCALE, Constant.DEFAULT_ROUND);
    }

    public static BigDecimal multiply(BigDecimal first,  BigDecimal second)
    {
        if(first == null || second == null)
            throw new RuntimeException("can't multiply null values");
        return first.multiply(second).setScale(Constant.DEFAULT_SCALE, Constant.DEFAULT_ROUND);
    }

    public static BigDecimal divide(BigDecimal first,  BigDecimal second)
    {
        if(first == null || second == null)
            throw new RuntimeException("can't divide null values");
        return first.divide(second, Constant.DEFAULT_SCALE, Constant.DEFAULT_ROUND);
    }


    /**
     * Get max value from given values.
     * @param first    first given
     * @param second   second value
     * @return max value.
     */
    public static BigDecimal max(final BigDecimal first, final BigDecimal second) {
        if (isFirstBiggerThanSecond(
                notNull(first),
                notNull(second))) {
            return notNull(first);
        }
        return notNull(second);
    }

    /**
     * Get minimal, but greater than 0 value from given values.
     * @param first    first given
     * @param second   second value
     * @return max value.
     */
    public static BigDecimal minPositive(final BigDecimal first, final BigDecimal second) {
        if ( first == null || notNull(first).equals(BigDecimal.ZERO) ) {
            return notNull(second);
        } else if ( second == null || notNull(second).equals(BigDecimal.ZERO) ) {
            return notNull(first);
        } else  if (isFirstBiggerThanSecond(
                notNull(first),
                notNull(second))) {
            return notNull(second);
        }
        return notNull(first);
    }

    /**
     *
     * @param value value to check
     * @return value if it not null, otherwise BigDecimal.ZERO
     */
    public static BigDecimal notNull(final BigDecimal value) {
        return notNull(value, null);
    }

    /**
     * @param value  value to check
     * @param ifNull value to return if value to check is null
     * @return value or ifNull if value is null. if ifNull is null returns BigDecimal.ZERO.
     */
    public static BigDecimal notNull(final BigDecimal value, final BigDecimal ifNull) {
        if (value == null) {
            if (ifNull == null) {
                return BigDecimal.ZERO;
            }
            return ifNull;
        }
        return value;
    }

    /**
     * @param first  value
     * @param second value
     * @return true if first is greater than second (null safe)
     */
    public static boolean isFirstBiggerThanSecond(final BigDecimal first, final BigDecimal second) {

        if (first == null && second == null) {
            return false;
        } else if (second == null) {
            return true;
        } else if (first == null) {
            return false;
        }
        return first.compareTo(second) > 0;

    }

    /**
     * @param first  value
     * @param second value
     * @return true if first is greater than or equal to second (null safe)
     */
    public static boolean isFirstBiggerThanOrEqualToSecond(final BigDecimal first, final BigDecimal second) {

        if (first == null && second == null) {
            return false;
        } else if (second == null) {
            return true;
        } else if (first == null) {
            return false;
        }
        return first.compareTo(second) >= 0;

    }

    /**
     * @param first  value
     * @param second value
     * @return true if first is equal to second (null safe)
     */
    public static boolean isFirstEqualToSecond(final BigDecimal first, final BigDecimal second) {

        if (first == null && second == null) {
            return false;
        } else if (second == null) {
            return false;
        } else if (first == null) {
            return false;
        }
        return first.compareTo(second) == 0;

    }

    /**
     * @param first  value
     * @param second value
     * @param scale  scale
     * @return true if first is equal to second (null safe)
     */
    public static boolean isFirstEqualToSecond(final BigDecimal first, final BigDecimal second, final int scale) {

        if (first == null && second == null) {
            return false;
        } else if (second == null) {
            return false;
        } else if (first == null) {
            return false;
        }
        return first.setScale(scale).compareTo(second.setScale(scale)) == 0;

    }

    /**
     * Get discount as percentage.
     * E.g. original 100.00, discounted 80.0 - the result will be 80 (%)
     * E.g. original 100.00, discounted 80.99 - the result will be 80 (%)
     *
     * @param original original price
     * @param discounted discounted price
     * @return discount in percent
     */
    public static BigDecimal getDiscountDisplayValue(final BigDecimal original, final BigDecimal discounted) {

        if (original == null || discounted == null) {
            return BigDecimal.ZERO;
        }
        return discounted.multiply(Constant.HUNDREDDECIMAL)
                .divide(original, Constant.DEFAULT_ROUND).setScale(0, Constant.DEFAULT_ROUND);
    }


}
