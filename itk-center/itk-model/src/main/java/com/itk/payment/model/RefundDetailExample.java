package com.itk.payment.model;

import java.util.ArrayList;
import java.util.List;

public class RefundDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public RefundDetailExample() {
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

        public Criteria andRefundDetailIdIsNull() {
            addCriterion("refund_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdIsNotNull() {
            addCriterion("refund_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdEqualTo(String value) {
            addCriterion("refund_detail_id =", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdNotEqualTo(String value) {
            addCriterion("refund_detail_id <>", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdGreaterThan(String value) {
            addCriterion("refund_detail_id >", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("refund_detail_id >=", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdLessThan(String value) {
            addCriterion("refund_detail_id <", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdLessThanOrEqualTo(String value) {
            addCriterion("refund_detail_id <=", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdLike(String value) {
            addCriterion("refund_detail_id like", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdNotLike(String value) {
            addCriterion("refund_detail_id not like", value, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdIn(List<String> values) {
            addCriterion("refund_detail_id in", values, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdNotIn(List<String> values) {
            addCriterion("refund_detail_id not in", values, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdBetween(String value1, String value2) {
            addCriterion("refund_detail_id between", value1, value2, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundDetailIdNotBetween(String value1, String value2) {
            addCriterion("refund_detail_id not between", value1, value2, "refundDetailId");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNull() {
            addCriterion("flow_id is null");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNotNull() {
            addCriterion("flow_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlowIdEqualTo(String value) {
            addCriterion("flow_id =", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotEqualTo(String value) {
            addCriterion("flow_id <>", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThan(String value) {
            addCriterion("flow_id >", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThanOrEqualTo(String value) {
            addCriterion("flow_id >=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThan(String value) {
            addCriterion("flow_id <", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThanOrEqualTo(String value) {
            addCriterion("flow_id <=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLike(String value) {
            addCriterion("flow_id like", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotLike(String value) {
            addCriterion("flow_id not like", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdIn(List<String> values) {
            addCriterion("flow_id in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotIn(List<String> values) {
            addCriterion("flow_id not in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdBetween(String value1, String value2) {
            addCriterion("flow_id between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotBetween(String value1, String value2) {
            addCriterion("flow_id not between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdIsNull() {
            addCriterion("order_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdIsNotNull() {
            addCriterion("order_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdEqualTo(String value) {
            addCriterion("order_detail_id =", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotEqualTo(String value) {
            addCriterion("order_detail_id <>", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdGreaterThan(String value) {
            addCriterion("order_detail_id >", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_detail_id >=", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdLessThan(String value) {
            addCriterion("order_detail_id <", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdLessThanOrEqualTo(String value) {
            addCriterion("order_detail_id <=", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdLike(String value) {
            addCriterion("order_detail_id like", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotLike(String value) {
            addCriterion("order_detail_id not like", value, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdIn(List<String> values) {
            addCriterion("order_detail_id in", values, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotIn(List<String> values) {
            addCriterion("order_detail_id not in", values, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdBetween(String value1, String value2) {
            addCriterion("order_detail_id between", value1, value2, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andOrderDetailIdNotBetween(String value1, String value2) {
            addCriterion("order_detail_id not between", value1, value2, "orderDetailId");
            return (Criteria) this;
        }

        public Criteria andRefundCountIsNull() {
            addCriterion("refund_count is null");
            return (Criteria) this;
        }

        public Criteria andRefundCountIsNotNull() {
            addCriterion("refund_count is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCountEqualTo(Integer value) {
            addCriterion("refund_count =", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotEqualTo(Integer value) {
            addCriterion("refund_count <>", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountGreaterThan(Integer value) {
            addCriterion("refund_count >", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("refund_count >=", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountLessThan(Integer value) {
            addCriterion("refund_count <", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountLessThanOrEqualTo(Integer value) {
            addCriterion("refund_count <=", value, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountIn(List<Integer> values) {
            addCriterion("refund_count in", values, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotIn(List<Integer> values) {
            addCriterion("refund_count not in", values, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountBetween(Integer value1, Integer value2) {
            addCriterion("refund_count between", value1, value2, "refundCount");
            return (Criteria) this;
        }

        public Criteria andRefundCountNotBetween(Integer value1, Integer value2) {
            addCriterion("refund_count not between", value1, value2, "refundCount");
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