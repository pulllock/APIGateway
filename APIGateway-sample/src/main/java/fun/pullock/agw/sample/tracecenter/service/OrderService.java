package fun.pullock.agw.sample.tracecenter.service;

import fun.pullock.agw.sample.tracecenter.model.OrderDTO;
import fun.pullock.agw.sample.tracecenter.query.OrderQuery;
import fun.pullock.agw.sample.tracecenter.result.Result;

import java.util.List;

public interface OrderService {

    Result<List<OrderDTO>> queryOrders(OrderQuery query);
}
