# SpringBoot Application
# AKS CREATION AND ACR CREATION STEPS USING AZURE CLI
az group create --name AKSRG --location "West Europe"
az aks create --resource-group AKSRG --name aksgourav --enable-addons monitoring --generate-ssh-keys --location "West Europe"
az acr create --resource-group AKSRG --name acrgourav --sku Standard --location "West Europe"
CLIENT_ID=$(az aks show --resource-group AKSRG --name aksgourav --query "servicePrincipalProfile.clientId" --output tsv)
ACR_ID=$(az acr show --name acrgourav --resource-group AKSRG --query "id" --output tsv)
az role assignment create --assignee $CLIENT_ID --role acrpull --scope $ACR_ID

# CONNECTING TO CLUSTER
az  aks get-credentials --resource-group AKSRG --name aksgourav

az aks browse --resource-group=AKSRG --name=aksgourav

# KUBERNETS CLI
kubectl get pods
kubectl get service mhc-front --watch
kubectl create clusterrolebinding kubernetes-dashboard --clusterrole=cluster-admin --serviceaccount=kube-system:kubernetes-dashboard

