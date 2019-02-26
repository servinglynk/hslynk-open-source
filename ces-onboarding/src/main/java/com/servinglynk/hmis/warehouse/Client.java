package com.servinglynk.hmis.warehouse;

import java.util.UUID;

	public class Client {
		UUID clientId;
		UUID dedupClientId;
		public Client(UUID clientId, UUID dedupClientId) {
			super();
			this.clientId = clientId;
			this.dedupClientId = dedupClientId;
		}
		/**
		 * @return the clientId
		 */
		public UUID getClientId() {
			return clientId;
		}
		/**
		 * @param clientId the clientId to set
		 */
		public void setClientId(UUID clientId) {
			this.clientId = clientId;
		}
		/**
		 * @return the dedupClientId
		 */
		public UUID getDedupClientId() {
			return dedupClientId;
		}
		/**
		 * @param dedupClientId the dedupClientId to set
		 */
		public void setDedupClientId(UUID dedupClientId) {
			this.dedupClientId = dedupClientId;
		}
	}
