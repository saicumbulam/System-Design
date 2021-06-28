# sidecar pattern
- single-node pattern made up of two containers. 
- The first is the application container. It contains the core logic for the application.
- In addition to the application container, there is a sidecar container. The role of the sidecar is to augment and improve the application container. 


![picture 1](../images/2ba1a577c9b932b1b1e12003bda528ae07350e5e62581ba6c727a1574a3e75ef.png)  


Example use case: 
- Adding HTTPS to a Legacy Service
![picture 2](../images/4c6a870bf38f1926ef4868041d76891e196bac2aeb75af92c27126a213571ab9.png)  


- Dynamic Configuration with Sidecars
  When the legacy application starts, it loads its configuration from the filesystem, as expected. When the configuration manager starts, it examines the configuration API and looks for differences between the local filesystem and the configuration stored in the API. If there are differences, the configuration manager downloads the new configuration to the local filesystem and signals to the legacy application that it should reconfigure itself with this new configuration.

   
- platform as a service (PaaS) built around the gitworkflow. Once you deploy this PaaS, simply pushing new code upto a Git
  repository results in that code being deployed to the runningserver 

  ![picture 4](../images/a05a3ef63380955881fc8c6e836cc6d180e9f29363ce009e78e4b1b37a3def85.png)  

