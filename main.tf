provider "google" {
  project = "img-project-392101"
  region  = "us-west1"
}

resource "google_cloud_run_service" "default" {
  name     = "my-cloudrun-service"
  location = "us-west1"

  template {
    spec {
      containers {
        image = "us-west1-docker.pkg.dev/img-project-392101/west-repo/qa-app86:v1"
      }
    }
  }

  traffic {
    percent         = 100
    latest_revision = true
  }
}

data "google_iam_policy" "noauth" {
  binding {
    role    = "roles/run.invoker"
    members = ["allUsers"]
  }
}

resource "google_cloud_run_service_iam_policy" "noauth" {
  location    = google_cloud_run_service.default.location
  project     = google_cloud_run_service.default.project
  service     = google_cloud_run_service.default.name

  policy_data = data.google_iam_policy.noauth.policy_data
}
