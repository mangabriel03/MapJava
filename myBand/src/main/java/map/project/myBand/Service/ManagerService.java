package map.project.myBand.Service;

import jakarta.transaction.Transactional;
import map.project.myBand.Model.Manager;
import map.project.myBand.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public List<Manager> findAllManagers(){
        return this.managerRepository.findAll();
    }

    public Manager findManagerById(Long managerId) throws Exception {
        Optional<Manager> manager = this.managerRepository.findByManagerId(managerId);
        if(manager.isEmpty()){
            throw new Exception("There is no manager with this id");
        }
        else{
            return manager.get();
        }
    }
    @Transactional
    public void deleteManager(Long managerId) throws Exception {
        Optional<Manager> manager = this.managerRepository.findByManagerId(managerId);
        if(manager.isEmpty()){
            throw new Exception("There is no manager with this id");
        }
        else{
            this.managerRepository.deleteByManagerId(managerId);
        }
    }

    public void addManager(Manager manager){
        this.managerRepository.save(manager);
    }
}
