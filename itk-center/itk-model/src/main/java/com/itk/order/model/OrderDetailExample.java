package com.itk.order.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public OrderDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdIsNull() {
            addCriterion("item_info_id is null");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdIsNotNull() {
            addCriterion("item_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdEqualTo(String value) {
            addCriterion("item_info_id =", value, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdNotEqualTo(String value) {
            addCriterion("item_info_id <>", value, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdGreaterThan(String value) {
            addCriterion("item_info_id >", value, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_info_id >=", value, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdLessThan(String value) {
            addCriterion("item_info_id <", value, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdLessThanOrEqualTo(String value) {
            addCriterion("item_info_id <=", value, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdLike(String value) {
            addCriterion("item_info_id like", value, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdNotLike(String value) {
            addCriterion("item_info_id not like", value, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdIn(List<String> values) {
            addCriterion("item_info_id in", values, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdNotIn(List<String> values) {
            addCriterion("item_info_id not in", values, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdBetween(String value1, String value2) {
            addCriterion("item_info_id between", value1, value2, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemInfoIdNotBetween(String value1, String value2) {
            addCriterion("item_info_id not between", value1, value2, "itemInfoId");
            return (Criteria) this;
        }

        public Criteria andItemCountIsNull() {
            addCriterion("item_count is null");
            return (Criteria) this;
        }

        public Criteria andItemCountIsNotNull() {
            addCriterion("item_count is not null");
            return (Criteria) this;
        }

        public Criteria andItemCountEqualTo(Integer value) {
            addCriterion("item_count =", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotEqualTo(Integer value) {
            addCriterion("item_count <>", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountGreaterThan(Integer value) {
            addCriterion("item_count >", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_count >=", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountLessThan(Integer value) {
            addCriterion("item_count <", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountLessThanOrEqualTo(Integer value) {
            addCriterion("item_count <=", value, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountIn(List<Integer> values) {
            addCriterion("item_count in", values, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotIn(List<Integer> values) {
            addCriterion("item_count not in", values, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountBetween(Integer value1, Integer value2) {
            addCriterion("item_count between", value1, value2, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemCountNotBetween(Integer value1, Integer value2) {
            addCriterion("item_count not between", value1, value2, "itemCount");
            return (Criteria) this;
        }

        public Criteria andItemAmountIsNull() {
            addCriterion("item_amount is null");
            return (Criteria) this;
        }

        public Criteria andItemAmountIsNotNull() {
            addCriterion("item_amount is not null");
            return (Criteria) this;
        }

        public Criteria andItemAmountEqualTo(BigDecimal value) {
            addCriterion("item_amount =", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountNotEqualTo(BigDecimal value) {
            addCriterion("item_amount <>", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountGreaterThan(BigDecimal value) {
            addCriterion("item_amount >", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_amount >=", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountLessThan(BigDecimal value) {
            addCriterion("item_amount <", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_amount <=", value, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountIn(List<BigDecimal> values) {
            addCriterion("item_amount in", values, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountNotIn(List<BigDecimal> values) {
            addCriterion("item_amount not in", values, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_amount between", value1, value2, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andItemAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_amount not between", value1, value2, "itemAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNull() {
            addCriterion("actual_amount is null");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNotNull() {
            addCriterion("actual_amount is not null");
            return (Criteria) this;
        }

        public Criteria andActualAmountEqualTo(BigDecimal value) {
            addCriterion("actual_amount =", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotEqualTo(BigDecimal value) {
            addCriterion("actual_amount <>", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThan(BigDecimal value) {
            addCriterion("actual_amount >", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_amount >=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThan(BigDecimal value) {
            addCriterion("actual_amount <", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_amount <=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountIn(List<BigDecimal> values) {
            addCriterion("actual_amount in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotIn(List<BigDecimal> values) {
            addCriterion("actual_amount not in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_amount between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_amount not between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andFreightIdIsNull() {
            addCriterion("freight_id is null");
            return (Criteria) this;
        }

        public Criteria andFreightIdIsNotNull() {
            addCriterion("freight_id is not null");
            return (Criteria) this;
        }

        public Criteria andFreightIdEqualTo(Integer value) {
            addCriterion("freight_id =", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotEqualTo(Integer value) {
            addCriterion("freight_id <>", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdGreaterThan(Integer value) {
            addCriterion("freight_id >", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("freight_id >=", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdLessThan(Integer value) {
            addCriterion("freight_id <", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdLessThanOrEqualTo(Integer value) {
            addCriterion("freight_id <=", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdIn(List<Integer> values) {
            addCriterion("freight_id in", values, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotIn(List<Integer> values) {
            addCriterion("freight_id not in", values, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdBetween(Integer value1, Integer value2) {
            addCriterion("freight_id between", value1, value2, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotBetween(Integer value1, Integer value2) {
            addCriterion("freight_id not between", value1, value2, "freightId");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeIsNull() {
            addCriterion("platform_promotion_code is null");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeIsNotNull() {
            addCriterion("platform_promotion_code is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeEqualTo(Integer value) {
            addCriterion("platform_promotion_code =", value, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeNotEqualTo(Integer value) {
            addCriterion("platform_promotion_code <>", value, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeGreaterThan(Integer value) {
            addCriterion("platform_promotion_code >", value, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("platform_promotion_code >=", value, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeLessThan(Integer value) {
            addCriterion("platform_promotion_code <", value, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeLessThanOrEqualTo(Integer value) {
            addCriterion("platform_promotion_code <=", value, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeIn(List<Integer> values) {
            addCriterion("platform_promotion_code in", values, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeNotIn(List<Integer> values) {
            addCriterion("platform_promotion_code not in", values, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeBetween(Integer value1, Integer value2) {
            addCriterion("platform_promotion_code between", value1, value2, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("platform_promotion_code not between", value1, value2, "platformPromotionCode");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostIsNull() {
            addCriterion("platform_promotion_cost is null");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostIsNotNull() {
            addCriterion("platform_promotion_cost is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostEqualTo(BigDecimal value) {
            addCriterion("platform_promotion_cost =", value, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostNotEqualTo(BigDecimal value) {
            addCriterion("platform_promotion_cost <>", value, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostGreaterThan(BigDecimal value) {
            addCriterion("platform_promotion_cost >", value, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_promotion_cost >=", value, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostLessThan(BigDecimal value) {
            addCriterion("platform_promotion_cost <", value, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("platform_promotion_cost <=", value, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostIn(List<BigDecimal> values) {
            addCriterion("platform_promotion_cost in", values, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostNotIn(List<BigDecimal> values) {
            addCriterion("platform_promotion_cost not in", values, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_promotion_cost between", value1, value2, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andPlatformPromotionCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("platform_promotion_cost not between", value1, value2, "platformPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeIsNull() {
            addCriterion("shop_promotion_code is null");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeIsNotNull() {
            addCriterion("shop_promotion_code is not null");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeEqualTo(Integer value) {
            addCriterion("shop_promotion_code =", value, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeNotEqualTo(Integer value) {
            addCriterion("shop_promotion_code <>", value, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeGreaterThan(Integer value) {
            addCriterion("shop_promotion_code >", value, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_promotion_code >=", value, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeLessThan(Integer value) {
            addCriterion("shop_promotion_code <", value, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_promotion_code <=", value, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeIn(List<Integer> values) {
            addCriterion("shop_promotion_code in", values, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeNotIn(List<Integer> values) {
            addCriterion("shop_promotion_code not in", values, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeBetween(Integer value1, Integer value2) {
            addCriterion("shop_promotion_code between", value1, value2, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_promotion_code not between", value1, value2, "shopPromotionCode");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostIsNull() {
            addCriterion("shop_promotion_cost is null");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostIsNotNull() {
            addCriterion("shop_promotion_cost is not null");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostEqualTo(BigDecimal value) {
            addCriterion("shop_promotion_cost =", value, "shopPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostNotEqualTo(BigDecimal value) {
            addCriterion("shop_promotion_cost <>", value, "shopPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostGreaterThan(BigDecimal value) {
            addCriterion("shop_promotion_cost >", value, "shopPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shop_promotion_cost >=", value, "shopPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostLessThan(BigDecimal value) {
            addCriterion("shop_promotion_cost <", value, "shopPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shop_promotion_cost <=", value, "shopPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostIn(List<BigDecimal> values) {
            addCriterion("shop_promotion_cost in", values, "shopPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostNotIn(List<BigDecimal> values) {
            addCriterion("shop_promotion_cost not in", values, "shopPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shop_promotion_cost between", value1, value2, "shopPromotionCost");
            return (Criteria) this;
        }

        public Criteria andShopPromotionCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shop_promotion_cost not between", value1, value2, "shopPromotionCost");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}