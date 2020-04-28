use agw;
INSERT INTO agw_sys(id, created_time, modified_time, version, name, `desc`) VALUES (1, now(), now(), 1, 'tradecenter', '交易中心');
INSERT INTO agw_api(id, created_time, modified_time, version, code, name, method, alias, sys_id, timeout) VALUES (1, now(), now(), 1, '1TRW556GGH#TEST', 'me.cxis.agw.sample.tracecenter.service.OrderService', 'queryOrders', NULL, 1, 1000);
INSERT INTO agw_api_param(id, created_time, modified_time, version, api_id, name, type, `sequence`) VALUES (1, now(), now(), 1, 1, 'query', 'me.cxis.agw.sample.tracecenter.query.OrderQuery', 1);
INSERT INTO agw_out(id, created_time, modified_time, version, name, `desc`, code, ip_control) VALUES (1, now(), now(), 1, 'google', '谷歌', '678901345678905432HHHYGHD#google', 1);
INSERT INTO agw_out_api(id, created_time, modified_time, version, out_id, api_id) VALUES (1, now(), now(), 1, 1, 1);
INSERT INTO agw_out_ip(id, created_time, modified_time, version, out_id, ip) VALUES (1, now(), now(), 1, 1, '0:0:0:0:0:0:0:1');
