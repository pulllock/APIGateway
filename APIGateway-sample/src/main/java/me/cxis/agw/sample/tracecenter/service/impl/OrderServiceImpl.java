package me.cxis.agw.sample.tracecenter.service.impl;

import com.alibaba.fastjson.JSON;
import me.cxis.agw.sample.tracecenter.model.OrderDTO;
import me.cxis.agw.sample.tracecenter.query.OrderQuery;
import me.cxis.agw.sample.tracecenter.result.Result;
import me.cxis.agw.sample.tracecenter.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public Result<List<OrderDTO>> queryOrders(OrderQuery query) {
        LOGGER.info("query: {}", JSON.toJSONString(query));

        Result<List<OrderDTO>> result = new Result<>();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("retBuyer名字");
        orderDTO.setId(1000L);
        orderDTO.setPrice(100.0);

        List<OrderDTO> list = new ArrayList<>();
        list.add(orderDTO);

        result.setModel(list);
        result.setSuccess(true);
        return result;
    }
}
