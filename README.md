# Skaffold config for development of Clojure apps

Features:
1. Runs in a local Kubernetes cluster
1. Code reloading
1. No need to restart the app to see changes
1. Automatic port forwarding


## Running it
1. Ensure Docker is running.
1. `minikube start`
1. `skaffold dev --port-forward`
1. `open locahost:3000`