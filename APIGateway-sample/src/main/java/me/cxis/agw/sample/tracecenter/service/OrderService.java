package me.cxis.agw.sample.tracecenter.service;

import me.cxis.agw.sample.tracecenter.model.OrderDTO;
import me.cxis.agw.sample.tracecenter.query.OrderQuery;
import me.cxis.agw.sample.tracecenter.result.Result;

import java.util.List;

public interface OrderService {

    Result<List<OrderDTO>> queryOrders(OrderQuery query);
}
