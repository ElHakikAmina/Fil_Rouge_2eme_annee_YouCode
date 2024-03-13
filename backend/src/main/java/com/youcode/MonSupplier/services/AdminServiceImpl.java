package com.youcode.MonSupplier.services;

import com.youcode.MonSupplier.models.Entities.Admin;
import com.youcode.MonSupplier.models.Entities.Buyer;
import com.youcode.MonSupplier.models.Entities.Supplier;
import com.youcode.MonSupplier.models.Enums.RoleUser;
import com.youcode.MonSupplier.repositories.AdminRepository;
import com.youcode.MonSupplier.repositories.BuyerRepository;
import com.youcode.MonSupplier.repositories.SupplierRepository;
import com.youcode.MonSupplier.services.interfaces.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final BuyerRepository buyerRepository;
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    public AdminServiceImpl(AdminRepository adminRepository, ModelMapper modelMapper, BuyerRepository buyerRepository, SupplierRepository supplierRepository) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
        this.buyerRepository = buyerRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List getAll(RoleUser roleUser) {
        if (roleUser == RoleUser.Admin){
            return adminRepository.findAll();
        } else if (roleUser == RoleUser.Buyer){
            return buyerRepository.findAll();
        } else if (roleUser == RoleUser.Supplier){
            return supplierRepository.findAll();
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(RoleUser roleUser, Long id) {
        if (roleUser == RoleUser.Admin){
            adminRepository.deleteById(id);
        } else if (roleUser == RoleUser.Buyer){
            buyerRepository.deleteById(id);
        }  else if (roleUser == RoleUser.Supplier){
            supplierRepository.deleteById(id);
        }
    }

    @Override
    public Object getById(RoleUser roleUser, Long id) {
        if (roleUser == RoleUser.Admin){
            return adminRepository.findById(id);
        } else if (roleUser == RoleUser.Buyer){
            return buyerRepository.findById(id);
        } else if (roleUser == RoleUser.Supplier){
            return supplierRepository.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public Object create(RoleUser roleUser, Object object) {
        String objectString = object.toString();
        String[] objectStringArray = objectString.split(", ");
        String objectStringEmail = objectStringArray[0];
        String objectStringPassword = objectStringArray[1];
        String email = objectStringEmail.split("email=")[1];
        String password = objectStringPassword.split("password=")[1];
        if (adminRepository.existsByEmail(email) || buyerRepository.existsByEmail(email) || supplierRepository.existsByEmail(email)){
            return null;
        }
        if (roleUser == RoleUser.Admin){
            Admin admin = getAdminInCreate(email, password);
            return adminRepository.save(admin);
        } else if (roleUser == RoleUser.Buyer){
            Buyer buyer = getBuyerInCreate(objectStringArray, email, password);
            return buyerRepository.save(buyer);
        } else if (roleUser == RoleUser.Supplier){
            Supplier supplier = getSupplierInCreate(objectStringArray, email, password);
            supplier.setIsVerifie(true);
            return supplierRepository.save(supplier);
        } else {
            return null;
        }
    }

    @Override
    public Object update(RoleUser roleUser, Object object) {
        String objectString = object.toString();
        String[] objectStringArray = objectString.split(", ");
        String objectStringId = objectStringArray[0];
        String objectStringEmail = objectStringArray[1];
        String objectStringPassword = objectStringArray[2];
        Long id = Long.parseLong(objectStringId.split("id=")[1]);
        String email = objectStringEmail.split("email=")[1];
        String password = objectStringPassword.split("password=")[1];
        if (adminRepository.existsByEmail(email) || buyerRepository.existsByEmail(email) || supplierRepository.existsByEmail(email)) {

            if (roleUser == RoleUser.Admin) {
                Admin admin = getAdminInUpdate(id, email, password);
                return adminRepository.save(admin);
            } else if (roleUser == RoleUser.Buyer) {
                Buyer buyer = getBuyerInUpdate(objectStringArray, id, email, password);
                return buyerRepository.save(buyer);
            } else if (roleUser == RoleUser.Supplier) {
                Supplier supplier = getSupplierInUpdate(objectStringArray, id, email, password);
                supplier.setIsVerifie(true);
                return supplierRepository.save(supplier);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private Supplier getSupplierInCreate(String[] objectStringArray, String email, String password) {
        String objectStringImage = objectStringArray[2];
        String objectStringNom = objectStringArray[3];
        String image = objectStringImage.split("image=")[1];
        String nom = objectStringNom.split("nom=")[1];
        nom = nom.substring(0, nom.length() - 1);
        Supplier supplier = new Supplier();
        supplier.setEmail(email);
        supplier.setPassword(password);
        supplier.setNom(nom);
        supplier.setImage(image);
        supplier.setRoleUser(RoleUser.Supplier);
        supplier.setIsVerifie(true);
        return supplier;
    }

    private Admin getAdminInCreate(String email, String password) {
        Admin admin = new Admin();
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setRoleUser(RoleUser.Admin);
        return admin;
    }

    private static Buyer getBuyerInCreate(String[] objectStringArray, String email, String password) {
        String objectStringPrenom = objectStringArray[2];
        String objectStringNom = objectStringArray[3];
        String prenom = objectStringPrenom.split("prenom=")[1];
        String nom = objectStringNom.split("nom=")[1];
        nom = nom.substring(0, nom.length() - 1);
        Buyer buyer = new Buyer();
        buyer.setEmail(email);
        buyer.setPassword(password);
        buyer.setNom(nom);
        buyer.setPrenom(prenom);
        buyer.setRoleUser(RoleUser.Buyer);
        buyer.setIsVerifie(true);
        return buyer;
    }
    private Supplier getSupplierInUpdate(String[] objectStringArray, Long id, String email, String password) {
        String objectStringImage = objectStringArray[3];
        String objectStringNom = objectStringArray[4];
        String image = objectStringImage.split("image=")[1];
        String nom = objectStringNom.split("nom=")[1];
        nom = nom.substring(0, nom.length() - 1);
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setEmail(email);
        supplier.setPassword(password);
        supplier.setNom(nom);
        supplier.setImage(image);
        supplier.setRoleUser(RoleUser.Supplier);
        supplier.setIsVerifie(true);
        return supplier;
    }

    private Admin getAdminInUpdate(Long id, String email, String password) {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setEmail(email);
        admin.setPassword(password);
        admin.setRoleUser(RoleUser.Admin);
        return admin;
    }

    private static Buyer getBuyerInUpdate(String[] objectStringArray, Long id, String email, String password) {
        String objectStringPrenom = objectStringArray[3];
        String objectStringNom = objectStringArray[4];
        String prenom = objectStringPrenom.split("prenom=")[1];
        String nom = objectStringNom.split("nom=")[1];
        nom = nom.substring(0, nom.length() - 1);
        Buyer buyer = new Buyer();
        buyer.setId(id);
        buyer.setEmail(email);
        buyer.setPassword(password);
        buyer.setNom(nom);
        buyer.setPrenom(prenom);
        buyer.setRoleUser(RoleUser.Buyer);
        buyer.setIsVerifie(true);
        return buyer;
    }
}
