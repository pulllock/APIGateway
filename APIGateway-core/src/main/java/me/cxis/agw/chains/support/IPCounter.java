package me.cxis.agw.chains.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class IPCounter {

    /**
     * 保存ip访问的次数
     * key：ip
     * value：访问次数
     */
    private Map<String, AtomicInteger> counterMap = new ConcurrentHashMap<>();

    /**
     * 保存ip访问的时间
     * key：ip
     * value：时间戳
     */
    private Map<String, Long> timeMap = new ConcurrentHashMap<>();

    /**
     * 指定的次数
     */
    private int countRule;

    /**
     * 指定的时间，毫秒
     */
    private long timeRule;

    public IPCounter(int countRule, long timeRule) {
        this.countRule = countRule;
        this.timeRule = timeRule * 1000;
    }

    public boolean allow(String ip) {
        Long time = timeMap.get(ip);
        Long now = System.currentTimeMillis();

        // 不存在或者上一个时间窗口已经过去，重置时间和计数器
        if (time == null || (now - time) > timeRule) {
            timeMap.put(ip, now);
            counterMap.put(ip, new AtomicInteger());
        }

        AtomicInteger count = counterMap.get(ip);
        int temp = 1;
        if (count != null) {
            temp = count.incrementAndGet();
        }

        return temp <= countRule;
    }

    public int getCountRule() {
        return countRule;
    }

    public void setCountRule(int countRule) {
        this.countRule = countRule;
    }

    public long getTimeRule() {
        return timeRule;
    }

    public void setTimeRule(long timeRule) {
        this.timeRule = timeRule;
    }

    public static void main(String[] args) {
        // 10秒不能超过5次
        IPCounter counter = new IPCounter(5, 10);
        String ip = "192.168.1.1";
        System.out.println(counter.allow(ip));
        System.out.println(counter.allow(ip));
        System.out.println(counter.allow(ip));
        System.out.println(counter.allow(ip));
        System.out.println(counter.allow(ip));
        System.out.println(counter.allow(ip));
    }
}
