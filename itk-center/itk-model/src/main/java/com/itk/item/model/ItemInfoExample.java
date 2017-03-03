package com.itk.item.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ItemInfoExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andMainsrcIsNull() {
            addCriterion("mainSrc is null");
            return (Criteria) this;
        }

        public Criteria andMainsrcIsNotNull() {
            addCriterion("mainSrc is not null");
            return (Criteria) this;
        }

        public Criteria andMainsrcEqualTo(String value) {
            addCriterion("mainSrc =", value, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcNotEqualTo(String value) {
            addCriterion("mainSrc <>", value, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcGreaterThan(String value) {
            addCriterion("mainSrc >", value, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcGreaterThanOrEqualTo(String value) {
            addCriterion("mainSrc >=", value, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcLessThan(String value) {
            addCriterion("mainSrc <", value, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcLessThanOrEqualTo(String value) {
            addCriterion("mainSrc <=", value, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcLike(String value) {
            addCriterion("mainSrc like", value, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcNotLike(String value) {
            addCriterion("mainSrc not like", value, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcIn(List<String> values) {
            addCriterion("mainSrc in", values, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcNotIn(List<String> values) {
            addCriterion("mainSrc not in", values, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcBetween(String value1, String value2) {
            addCriterion("mainSrc between", value1, value2, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andMainsrcNotBetween(String value1, String value2) {
            addCriterion("mainSrc not between", value1, value2, "mainsrc");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNull() {
            addCriterion("bar_code is null");
            return (Criteria) this;
        }

        public Criteria andBarCodeIsNotNull() {
            addCriterion("bar_code is not null");
            return (Criteria) this;
        }

        public Criteria andBarCodeEqualTo(String value) {
            addCriterion("bar_code =", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotEqualTo(String value) {
            addCriterion("bar_code <>", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThan(String value) {
            addCriterion("bar_code >", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bar_code >=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThan(String value) {
            addCriterion("bar_code <", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLessThanOrEqualTo(String value) {
            addCriterion("bar_code <=", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeLike(String value) {
            addCriterion("bar_code like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotLike(String value) {
            addCriterion("bar_code not like", value, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeIn(List<String> values) {
            addCriterion("bar_code in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotIn(List<String> values) {
            addCriterion("bar_code not in", values, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeBetween(String value1, String value2) {
            addCriterion("bar_code between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andBarCodeNotBetween(String value1, String value2) {
            addCriterion("bar_code not between", value1, value2, "barCode");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(String value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(String value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(String value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(String value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(String value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLike(String value) {
            addCriterion("item_id like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotLike(String value) {
            addCriterion("item_id not like", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<String> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<String> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(String value1, String value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(String value1, String value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andDetailsrcIsNull() {
            addCriterion("detailSrc is null");
            return (Criteria) this;
        }

        public Criteria andDetailsrcIsNotNull() {
            addCriterion("detailSrc is not null");
            return (Criteria) this;
        }

        public Criteria andDetailsrcEqualTo(String value) {
            addCriterion("detailSrc =", value, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcNotEqualTo(String value) {
            addCriterion("detailSrc <>", value, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcGreaterThan(String value) {
            addCriterion("detailSrc >", value, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcGreaterThanOrEqualTo(String value) {
            addCriterion("detailSrc >=", value, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcLessThan(String value) {
            addCriterion("detailSrc <", value, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcLessThanOrEqualTo(String value) {
            addCriterion("detailSrc <=", value, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcLike(String value) {
            addCriterion("detailSrc like", value, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcNotLike(String value) {
            addCriterion("detailSrc not like", value, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcIn(List<String> values) {
            addCriterion("detailSrc in", values, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcNotIn(List<String> values) {
            addCriterion("detailSrc not in", values, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcBetween(String value1, String value2) {
            addCriterion("detailSrc between", value1, value2, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andDetailsrcNotBetween(String value1, String value2) {
            addCriterion("detailSrc not between", value1, value2, "detailsrc");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNull() {
            addCriterion("current_price is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIsNotNull() {
            addCriterion("current_price is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceEqualTo(BigDecimal value) {
            addCriterion("current_price =", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotEqualTo(BigDecimal value) {
            addCriterion("current_price <>", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThan(BigDecimal value) {
            addCriterion("current_price >", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_price >=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThan(BigDecimal value) {
            addCriterion("current_price <", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_price <=", value, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceIn(List<BigDecimal> values) {
            addCriterion("current_price in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotIn(List<BigDecimal> values) {
            addCriterion("current_price not in", values, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_price between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andCurrentPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_price not between", value1, value2, "currentPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceIsNull() {
            addCriterion("history_price is null");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceIsNotNull() {
            addCriterion("history_price is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceEqualTo(BigDecimal value) {
            addCriterion("history_price =", value, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceNotEqualTo(BigDecimal value) {
            addCriterion("history_price <>", value, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceGreaterThan(BigDecimal value) {
            addCriterion("history_price >", value, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("history_price >=", value, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceLessThan(BigDecimal value) {
            addCriterion("history_price <", value, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("history_price <=", value, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceIn(List<BigDecimal> values) {
            addCriterion("history_price in", values, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceNotIn(List<BigDecimal> values) {
            addCriterion("history_price not in", values, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("history_price between", value1, value2, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andHistoryPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("history_price not between", value1, value2, "historyPrice");
            return (Criteria) this;
        }

        public Criteria andPayPeriodIsNull() {
            addCriterion("pay_period is null");
            return (Criteria) this;
        }

        public Criteria andPayPeriodIsNotNull() {
            addCriterion("pay_period is not null");
            return (Criteria) this;
        }

        public Criteria andPayPeriodEqualTo(String value) {
            addCriterion("pay_period =", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodNotEqualTo(String value) {
            addCriterion("pay_period <>", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodGreaterThan(String value) {
            addCriterion("pay_period >", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("pay_period >=", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodLessThan(String value) {
            addCriterion("pay_period <", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodLessThanOrEqualTo(String value) {
            addCriterion("pay_period <=", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodLike(String value) {
            addCriterion("pay_period like", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodNotLike(String value) {
            addCriterion("pay_period not like", value, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodIn(List<String> values) {
            addCriterion("pay_period in", values, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodNotIn(List<String> values) {
            addCriterion("pay_period not in", values, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodBetween(String value1, String value2) {
            addCriterion("pay_period between", value1, value2, "payPeriod");
            return (Criteria) this;
        }

        public Criteria andPayPeriodNotBetween(String value1, String value2) {
            addCriterion("pay_period not between", value1, value2, "payPeriod");
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

        public Criteria andShopCategoryIdIsNull() {
            addCriterion("shop_category_id is null");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdIsNotNull() {
            addCriterion("shop_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdEqualTo(Integer value) {
            addCriterion("shop_category_id =", value, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdNotEqualTo(Integer value) {
            addCriterion("shop_category_id <>", value, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdGreaterThan(Integer value) {
            addCriterion("shop_category_id >", value, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_category_id >=", value, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdLessThan(Integer value) {
            addCriterion("shop_category_id <", value, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("shop_category_id <=", value, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdIn(List<Integer> values) {
            addCriterion("shop_category_id in", values, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdNotIn(List<Integer> values) {
            addCriterion("shop_category_id not in", values, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("shop_category_id between", value1, value2, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andShopCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_category_id not between", value1, value2, "shopCategoryId");
            return (Criteria) this;
        }

        public Criteria andTotalStockIsNull() {
            addCriterion("total_stock is null");
            return (Criteria) this;
        }

        public Criteria andTotalStockIsNotNull() {
            addCriterion("total_stock is not null");
            return (Criteria) this;
        }

        public Criteria andTotalStockEqualTo(Integer value) {
            addCriterion("total_stock =", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockNotEqualTo(Integer value) {
            addCriterion("total_stock <>", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockGreaterThan(Integer value) {
            addCriterion("total_stock >", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_stock >=", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockLessThan(Integer value) {
            addCriterion("total_stock <", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockLessThanOrEqualTo(Integer value) {
            addCriterion("total_stock <=", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockIn(List<Integer> values) {
            addCriterion("total_stock in", values, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockNotIn(List<Integer> values) {
            addCriterion("total_stock not in", values, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockBetween(Integer value1, Integer value2) {
            addCriterion("total_stock between", value1, value2, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockNotBetween(Integer value1, Integer value2) {
            addCriterion("total_stock not between", value1, value2, "totalStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockIsNull() {
            addCriterion("current_stock is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStockIsNotNull() {
            addCriterion("current_stock is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStockEqualTo(Integer value) {
            addCriterion("current_stock =", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockNotEqualTo(Integer value) {
            addCriterion("current_stock <>", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockGreaterThan(Integer value) {
            addCriterion("current_stock >", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_stock >=", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockLessThan(Integer value) {
            addCriterion("current_stock <", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockLessThanOrEqualTo(Integer value) {
            addCriterion("current_stock <=", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockIn(List<Integer> values) {
            addCriterion("current_stock in", values, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockNotIn(List<Integer> values) {
            addCriterion("current_stock not in", values, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockBetween(Integer value1, Integer value2) {
            addCriterion("current_stock between", value1, value2, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockNotBetween(Integer value1, Integer value2) {
            addCriterion("current_stock not between", value1, value2, "currentStock");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNull() {
            addCriterion("updator is null");
            return (Criteria) this;
        }

        public Criteria andUpdatorIsNotNull() {
            addCriterion("updator is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatorEqualTo(String value) {
            addCriterion("updator =", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotEqualTo(String value) {
            addCriterion("updator <>", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThan(String value) {
            addCriterion("updator >", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("updator >=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThan(String value) {
            addCriterion("updator <", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLessThanOrEqualTo(String value) {
            addCriterion("updator <=", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorLike(String value) {
            addCriterion("updator like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotLike(String value) {
            addCriterion("updator not like", value, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorIn(List<String> values) {
            addCriterion("updator in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotIn(List<String> values) {
            addCriterion("updator not in", values, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorBetween(String value1, String value2) {
            addCriterion("updator between", value1, value2, "updator");
            return (Criteria) this;
        }

        public Criteria andUpdatorNotBetween(String value1, String value2) {
            addCriterion("updator not between", value1, value2, "updator");
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