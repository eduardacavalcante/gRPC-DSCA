public class HelloServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server is running.");

        Server server = ServerBuilder.forPort(50055)
                .addService(new HelloServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received shutdown request");
            server.shutdown();

            System.out.println("Successfully stopped the server.");
        } ));

        server.awaitTermination();



    }

}
