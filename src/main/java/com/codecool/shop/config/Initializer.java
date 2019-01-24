package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier bayer = new Supplier("Bayer", "Bayer AG is a German multinational pharmaceutical and life sciences company and one of the largest pharmaceutical companies in the world.");
        supplierDataStore.add(bayer);
        Supplier monsanto = new Supplier("Monsanto", "The Monsanto Company was an American agrochemical and agricultural biotechnology corporation.");
        supplierDataStore.add(monsanto);
        Supplier dow = new Supplier("Dow Chemical Company", "The Dow Chemical Company, commonly referred to as Dow, is an American multinational chemical corporation headquartered in Midland, Michigan, United States, and the predecessor of the merged company DowDuPont.");
        supplierDataStore.add(dow);

        //setting up a new product category
        ProductCategory herbivorous = new ProductCategory("Herbivorous", "Dinosaur", "Vegan");
        ProductCategory carnivorous = new ProductCategory("Carnivorous", "Dinosaur", "Not vegan");
        ProductCategory omnivorous = new ProductCategory("Omnivorous", "Dinosaur", "Not that vegan");
        productCategoryDataStore.add(herbivorous);
        productCategoryDataStore.add(carnivorous);
        productCategoryDataStore.add(omnivorous);

        //setting up products and printing it
        productDataStore.add(new Product("T-rex", 49, "USD", " A genus of coelurosaurian theropod dinosaur. The species Tyrannosaurus rex (rex meaning \"king\" in Latin), is one of the most well-represented of the large theropods.", carnivorous, bayer));
        productDataStore.add(new Product("Velociraptor", 479, "USD", "A genus of dromaeosaurid theropod dinosaur that lived approximately 75 to 71 million years ago during the latter part of the Cretaceous Period.", omnivorous, dow));
        productDataStore.add(new Product("Diplodocus", 89, "USD", "One of the longest dinosaurs, Diplodocus had a unique body construction, with two rows of bones on the underside of its tail to provide extra support and greater mobility.", herbivorous, monsanto));
        productDataStore.add(new Product("Oviraptor",900,"USD","a genus of small Mongolian theropod dinosaurs, first discovered by technician George Olsen in an expedition led by Roy Chapman Andrews, and first described by Henry Fairfield Osborn, in 1924.", omnivorous, bayer));
        productDataStore.add(new Product("Argentinosaurus",850,"USD","a genus of titanosaur sauropod dinosaur first discovered by Guillermo Heredia in Argentina. The generic name refers to the country in which it was discovered.",carnivorous,monsanto));
        productDataStore.add(new Product("Giganotosaurus",90,"USD","Giganotosaurus was one of the largest meat-eating dinosaurs. It roamed modern-day Argentina during the late Cretaceous Period, about 99.6 to 97 million years ago.", carnivorous, bayer));
        }
}
