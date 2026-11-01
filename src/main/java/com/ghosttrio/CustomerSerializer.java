package com.ghosttrio;

import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
// 직접 정의하는 것은 문제가 많기 때문에 범용 라이브리러 사용한다.
public class CustomerSerializer implements Serializer<Customer> {
    @Override
    public byte[] serialize(String topic, Customer data) {
        try {
            byte[] serializedName;
            int stringSize;
            if (data == null) {
                return null;
            } else {
                if (data.getCustomerName() != null) {
                    serializedName = data.getCustomerName().getBytes("UTF-8");
                    stringSize = serializedName.length;
                } else {
                    serializedName = new byte[0];
                    stringSize = 0;
                }
            }

            ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + stringSize);
            buffer.putInt(data.getCustomerID());
            buffer.putInt(stringSize);
            buffer.put(serializedName);
            return buffer.array();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new byte[0];
    }
}
