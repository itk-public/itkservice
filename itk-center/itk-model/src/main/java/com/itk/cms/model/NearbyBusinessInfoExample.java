package com.itk.cms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NearbyBusinessInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public NearbyBusinessInfoExample() {
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

        public Criteria andNearbyBusinessIdIsNull() {
            addCriterion("nearby_business_id is null");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdIsNotNull() {
            addCriterion("nearby_business_id is not null");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdEqualTo(Long value) {
            addCriterion("nearby_business_id =", value, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdNotEqualTo(Long value) {
            addCriterion("nearby_business_id <>", value, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdGreaterThan(Long value) {
            addCriterion("nearby_business_id >", value, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("nearby_business_id >=", value, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdLessThan(Long value) {
            addCriterion("nearby_business_id <", value, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdLessThanOrEqualTo(Long value) {
            addCriterion("nearby_business_id <=", value, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdIn(List<Long> values) {
            addCriterion("nearby_business_id in", values, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdNotIn(List<Long> values) {
            addCriterion("nearby_business_id not in", values, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdBetween(Long value1, Long value2) {
            addCriterion("nearby_business_id between", value1, value2, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andNearbyBusinessIdNotBetween(Long value1, Long value2) {
            addCriterion("nearby_business_id not between", value1, value2, "nearbyBusinessId");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionIsNull() {
            addCriterion("whether_promotion is null");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionIsNotNull() {
            addCriterion("whether_promotion is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionEqualTo(Integer value) {
            addCriterion("whether_promotion =", value, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionNotEqualTo(Integer value) {
            addCriterion("whether_promotion <>", value, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionGreaterThan(Integer value) {
            addCriterion("whether_promotion >", value, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionGreaterThanOrEqualTo(Integer value) {
            addCriterion("whether_promotion >=", value, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionLessThan(Integer value) {
            addCriterion("whether_promotion <", value, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionLessThanOrEqualTo(Integer value) {
            addCriterion("whether_promotion <=", value, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionIn(List<Integer> values) {
            addCriterion("whether_promotion in", values, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionNotIn(List<Integer> values) {
            addCriterion("whether_promotion not in", values, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionBetween(Integer value1, Integer value2) {
            addCriterion("whether_promotion between", value1, value2, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherPromotionNotBetween(Integer value1, Integer value2) {
            addCriterion("whether_promotion not between", value1, value2, "whetherPromotion");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberIsNull() {
            addCriterion("whether_month_order_number is null");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberIsNotNull() {
            addCriterion("whether_month_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberEqualTo(String value) {
            addCriterion("whether_month_order_number =", value, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberNotEqualTo(String value) {
            addCriterion("whether_month_order_number <>", value, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberGreaterThan(String value) {
            addCriterion("whether_month_order_number >", value, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("whether_month_order_number >=", value, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberLessThan(String value) {
            addCriterion("whether_month_order_number <", value, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("whether_month_order_number <=", value, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberLike(String value) {
            addCriterion("whether_month_order_number like", value, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberNotLike(String value) {
            addCriterion("whether_month_order_number not like", value, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberIn(List<String> values) {
            addCriterion("whether_month_order_number in", values, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberNotIn(List<String> values) {
            addCriterion("whether_month_order_number not in", values, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberBetween(String value1, String value2) {
            addCriterion("whether_month_order_number between", value1, value2, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andWhetherMonthOrderNumberNotBetween(String value1, String value2) {
            addCriterion("whether_month_order_number not between", value1, value2, "whetherMonthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberIsNull() {
            addCriterion("month_order_number is null");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberIsNotNull() {
            addCriterion("month_order_number is not null");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberEqualTo(Long value) {
            addCriterion("month_order_number =", value, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberNotEqualTo(Long value) {
            addCriterion("month_order_number <>", value, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberGreaterThan(Long value) {
            addCriterion("month_order_number >", value, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("month_order_number >=", value, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberLessThan(Long value) {
            addCriterion("month_order_number <", value, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberLessThanOrEqualTo(Long value) {
            addCriterion("month_order_number <=", value, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberIn(List<Long> values) {
            addCriterion("month_order_number in", values, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberNotIn(List<Long> values) {
            addCriterion("month_order_number not in", values, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberBetween(Long value1, Long value2) {
            addCriterion("month_order_number between", value1, value2, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andMonthOrderNumberNotBetween(Long value1, Long value2) {
            addCriterion("month_order_number not between", value1, value2, "monthOrderNumber");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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