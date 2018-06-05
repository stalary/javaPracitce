package com.stalary.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * RpcImporter
 * Rpc调用接收者
 * @author lirongqian
 * @since 2018/05/08
 */
public class RpcImporter<S> {
    @SuppressWarnings("unchecked")
    public S importer(final Class<?> serviceClass, final InetSocketAddress addr) {
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{serviceClass.getInterfaces()[0]},
                (proxy, method, args) -> {
                    Socket socket = null;
                    ObjectOutputStream output = null;
                    ObjectInputStream input = null;
                    try {
                        socket = new Socket();
                        socket.connect(addr);
                        output = new ObjectOutputStream(socket.getOutputStream());
                        output.writeUTF(serviceClass.getName());
                        output.writeUTF(method.getName());
                        output.writeObject(method.getParameterTypes());
                        output.writeObject(args);
                        input = new ObjectInputStream(socket.getInputStream());
                        return input.readObject();
                    } finally {
                        if (socket != null) {
                            socket.close();
                        }
                        if (output != null) {
                            output.close();
                        }
                        if (input != null) {
                            input.close();
                        }
                    }
                });
    }
}