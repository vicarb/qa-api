provider "google" {
  project = "terra-project-391200"
  region  = "us-central1"
}

resource "google_compute_instance" "default" {
  name         = "terra-springboot-instance"
  machine_type = "n1-standard-1"
  zone         = "us-central1-a"

  boot_disk {
    initialize_params {
      image = "debian-10-buster-v20230615"
    }
  }

  network_interface {
    network = "default"
  }

  metadata_startup_script = <<-EOF
    #!/bin/bash
    apt-get update
    apt-get install -y docker.io

    usermod -aG docker $USER

    systemctl enable docker
    systemctl start docker

    docker run -d -p 8082:8081 webcl/qa-api:latest
  EOF
}
