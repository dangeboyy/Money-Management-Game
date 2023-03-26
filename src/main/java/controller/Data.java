package controller;

import model.customerFamily.GrandParent;
import model.customerFamily.Parent;
import model.customerFamily.Sibling;
import model.factories.AbstractWoodFactory;
import model.factories.WoodenBookshelfFactory;
import model.factories.WoodenTableFactory;
import model.factories.WoodenWardrobeFactory;
import model.users.Customer;
import model.users.FactoryBoss;
import model.users.User;

import java.util.ArrayList;



public class Data {
    public static int availableIdForRequest=0;
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<FactoryBoss> factoryBosses = new ArrayList<>();
    public static ArrayList<Sibling> siblings = new ArrayList<>();
    public static ArrayList<Parent> parents = new ArrayList<>();
    public static ArrayList<GrandParent> grandParents = new ArrayList<>();
    public static ArrayList<WoodenBookshelfFactory> woodenBookshelfFactories = new ArrayList<>();
    public static ArrayList<WoodenTableFactory> woodenTableFactories = new ArrayList<>();
    public static ArrayList<WoodenWardrobeFactory> woodenWardrobeFactories = new ArrayList<>();
    public static ArrayList<AbstractWoodFactory> factories = new ArrayList<>();


    public static void loadUserData(){
        initFactoryBosses();
        initCustomers();
    }

    private static void initCustomers() {
        Customer ege = new Customer("ege","perim");
        GrandParent sedat = new GrandParent("sedat","perim", ege.getUserId());
        Parent mumin = new Parent("mumin","perim", ege.getUserId());
        Sibling berke = new Sibling("berke","perim", ege.getUserId());
        ege.setSiblingId(berke.getUserId());
        Customer mert = new Customer("mert","inan");
        GrandParent ibrahim = new GrandParent("ibrahim","inan",mert.getUserId());
        Parent muharrem = new Parent("muharrem","inan",mert.getUserId());
        Sibling melda = new Sibling("melda","inan",mert.getUserId());
        mert.setSiblingId(melda.getUserId());
        Customer kenan = new Customer("kenan","isik");
        GrandParent ayse = new GrandParent("ayse","isik",kenan.getUserId());
        Parent kadriye = new Parent("kadriye","isik",kenan.getUserId());
        Sibling ayhan = new Sibling("ayhan","isik",kenan.getUserId());
        kenan.setSiblingId(ayhan.getUserId());
        Customer ali = new Customer("ali","koc");
        GrandParent vehbi = new GrandParent("vehbi","koc", ali.getUserId());
        Parent rahmi = new Parent("rahmi","koc", ali.getUserId());
        Sibling mustafa = new Sibling("mustafa","koc", ali.getUserId());
        ali.setSiblingId(mustafa.getUserId());
    }

    private static void initFactoryBosses() {
       
        AbstractWoodFactory tableFactory = new WoodenTableFactory();
        AbstractWoodFactory bookshelfFactory = new WoodenBookshelfFactory();
         AbstractWoodFactory wardrobeFactory = new WoodenWardrobeFactory();
        FactoryBoss tugkan = new FactoryBoss("tugkan","tuglular");
        tugkan.setResponsibleFactoryId(tableFactory.getFactoryId());
        FactoryBoss dilek = new FactoryBoss("dilek","ozturk");
        dilek.setResponsibleFactoryId(bookshelfFactory.getFactoryId());
        FactoryBoss serhat = new FactoryBoss("serhat","caner");
        serhat.setResponsibleFactoryId(wardrobeFactory.getFactoryId());
    }


    public static void clearAll(){
        users.clear();
        siblings.clear();
        customers.clear();
        parents.clear();
        grandParents.clear();
        factoryBosses.clear();
        factories.clear();
        woodenTableFactories.clear();
        woodenBookshelfFactories.clear();
        woodenWardrobeFactories.clear();
    }

    public static void updateIdList(){
        for (User user : users) {
            if (user.getRequests()!=null){
                availableIdForRequest += user.getRequests().size();
            }
        }
    }

    public static void fillUserList(){
        users.addAll(siblings);
        users.addAll(parents);
        users.addAll(grandParents);
        users.addAll(factoryBosses);
        users.addAll(customers);
    }
    public static void fillFactoryList(){
        factories.addAll(woodenTableFactories);
        factories.addAll(woodenBookshelfFactories);
        factories.addAll(woodenWardrobeFactories);
    }
   


}