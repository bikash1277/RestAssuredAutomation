package api.endpoints;

public class Routes {
    /***
     * Swagger URI: https://petstore.swagger.io/v2
     *
     * Create user (POST): https://petstore.swagger.io/v2/user
     * get User (GET): https://petstore.swagger.io/v2/user/{username}
     * update User(PUT): https://petstore.swagger.io/v2/user/{username}
     * delete User(DELETE): https://petstore.swagger.io/v2/user/{username}
     *
     * ***/


    public static String base_url = "https://petstore.swagger.io/v2";

    //User Module
    public static String post_user_url = base_url + "/user";
    public static String get_user_url = base_url + "/user/{username}";
    public static String update_user_url = base_url + "/user/{username}";
    public static String delete_user_url = base_url + "/user/{username}";

    //pet Module
    public static String post_pet_url = base_url + "/pet";
    public static String get_pet_url = base_url + "/pet/{petId}";
    public static String update_pet_url = base_url + "/pet/{petId}";
    public static String delete_pet_url = base_url + "/pet/{petId}";

    //store Module
    public static String post_store_order_url = base_url + "/store/order";
    public static String get_store_order_url = base_url + "/store/order/{orderId}";
    public static String delete_store_order_url = base_url + "/store/order/{orderId}";

}
